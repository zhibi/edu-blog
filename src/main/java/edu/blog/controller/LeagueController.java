package edu.blog.controller;

import edu.blog.core.annocation.RequestLogin;
import edu.blog.core.base.controller.BaseController;
import edu.blog.core.mybatis.condition.MybatisCondition;
import edu.blog.domain.League;
import edu.blog.domain.LeagueProp;
import edu.blog.domain.LeagueUser;
import edu.blog.dto.BlogDTO;
import edu.blog.dto.LeagueUserDTO;
import edu.blog.mapper.BlogMapper;
import edu.blog.mapper.LeagueMapper;
import edu.blog.mapper.LeaguePropMapper;
import edu.blog.mapper.LeagueUserMapper;
import edu.blog.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 前端控制器
 *
 * @author 执笔
 * @date 2019-04-20  17:43:03
 */
@Controller
@RequestMapping("league")
public class LeagueController extends BaseController {

    @Autowired
    private LeagueMapper     leagueMapper;
    @Autowired
    private LeagueUserMapper leagueUserMapper;
    @Autowired
    private LeaguePropMapper leaguePropMapper;
    @Autowired
    private LeagueService    leagueService;
    @Autowired
    private BlogMapper       blogMapper;

    /**
     * 社团列表
     *
     * @return
     */
    @GetMapping("list")
    public String list(Model model) {
        List<League> leagueList = leagueMapper.selectAll();
        model.addAttribute("leagueList", leagueList);
        return "league/list";
    }


    /**
     * 我的社团
     *
     * @return
     */
    @GetMapping("myList")
    @RequestLogin
    public String myList(Model model, Integer leagueId) {
        // 用户的社团
        List<League> leagueList = leagueMapper.selectByUser(sessionUser().getId());
        model.addAttribute("leagueList", leagueList);
        // 社团详情
        League league = leagueMapper.selectByPrimaryKey(leagueId);
        if (league == null && leagueList.size() > 0) {
            league = leagueList.get(0);
        }
        if (null != league) {
            // 是否领导
            LeagueUser leagueUser = leagueUserMapper.selectOne(new LeagueUser()
                    .setLeagueId(league.getId())
                    .setUserId(sessionUser().getId()));
            model.addAttribute("leagueUser", leagueUser);
            model.addAttribute("leagueId", league.getId());
            // 用户
            List<LeagueUserDTO> leagueUserList = leagueUserMapper.selectDto(new MybatisCondition()
                    .eq("lu.league_Id", league.getId()));
            model.addAttribute("leagueUserList", leagueUserList);
            // 道具
            List<LeagueProp> leaguePropList = leaguePropMapper.selectByExample(new MybatisCondition()
                    .eq("league_Id", league.getId()));
            model.addAttribute("leaguePropList", leaguePropList);
        }
        return "league/my-list";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        League league = leagueMapper.selectByPrimaryKey(id);
        // 社团的博客
        List<BlogDTO> blogDTOList = blogMapper.selectDtoByLeague(id);
        model.addAttribute(league);
        model.addAttribute("blogDTOList",blogDTOList);
        // 判断是否已经加入
        if(sessionUser() != null){
            LeagueUser leagueUser = leagueUserMapper.selectOne(new LeagueUser().setUserId(sessionUser().getId()).setLeagueId(id));
            model.addAttribute(leagueUser);
        }
        return "league/detail";
    }

    /**
     * 删除道具
     *
     * @param id
     * @return
     */
    @GetMapping("delProp/{id}")
    @RequestLogin
    public String delProp(@PathVariable Integer id, RedirectAttributes model) {
        leaguePropMapper.deleteByPrimaryKey(id);
        model.addFlashAttribute(ERROR_MESSAGE, "删除成功");
        return refresh();
    }

    /**
     * 对用户申请审核
     *
     * @param id
     * @param model
     * @param status
     * @return
     */
    @GetMapping("userApply/{id}/{status}")
    @RequestLogin
    public String userApply(@PathVariable Integer id, RedirectAttributes model, @PathVariable LeagueUser.LeagueUserStatusEnum status) {
        LeagueUser leagueUser = leagueUserMapper.selectByPrimaryKey(id);
        leagueUser.setStatus(status);
        leagueUser.setUpdateTime(LocalDateTime.now());
        leagueService.auth(leagueUser);
        model.addFlashAttribute(ERROR_MESSAGE, "操作成功");
        return refresh();
    }

    /**
     * 添加道具
     *
     * @return
     */
    @GetMapping("addProp/{id}")
    @RequestLogin
    public String addProp(Model model, @PathVariable Integer id) {
        model.addAttribute(new LeagueProp().setLeagueId(id));
        return "league/prop-input";
    }

    /**
     * 添加道具
     *
     * @return
     */
    @PostMapping("addProp")
    @RequestLogin
    public String addProp(LeagueProp leagueProp) {
        if (leagueProp.getId() == null || leagueProp.getId() <= 0) {
            leagueProp.setCreateTime(LocalDateTime.now());
            leaguePropMapper.insertSelective(leagueProp);
        } else {
            leaguePropMapper.updateByPrimaryKeySelective(leagueProp);
        }
        return redirect("/league/myList?leagueId=" + leagueProp.getLeagueId());
    }

    /**
     * 道具详情
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("detailProp/{id}")
    @RequestLogin
    public String detailProp(@PathVariable Integer id, Model model) {
        LeagueProp leagueProp = leaguePropMapper.selectByPrimaryKey(id);
        model.addAttribute(leagueProp);
        return "league/prop-input";
    }


}
