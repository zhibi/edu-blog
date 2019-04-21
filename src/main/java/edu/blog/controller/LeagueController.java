package edu.blog.controller;

import edu.blog.core.annocation.RequestLogin;
import edu.blog.core.base.controller.BaseController;
import edu.blog.core.mybatis.condition.MybatisCondition;
import edu.blog.domain.League;
import edu.blog.domain.LeagueProp;
import edu.blog.domain.LeagueUser;
import edu.blog.dto.LeagueUserDTO;
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
    private LeagueService leagueService;

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
     * 申请加入
     *
     * @return
     */
    @RequestLogin
    @PostMapping("apply")
    public String apply(LeagueUser leagueUser) {
        LeagueUser one = leagueUserMapper.selectOne(new LeagueUser()
                .setUserId(sessionUser().getId())
                .setLeagueId(leagueUser.getLeagueId())
                .setStatus(LeagueUser.LeagueUserStatusEnum.AGREE));
        if (null != one) {
            return prompt("您已经是社团成员，不需要申请");
        }
        leagueUser.setUserId(sessionUser().getId())
                .setStatus(LeagueUser.LeagueUserStatusEnum.APPLY)
                .setType(LeagueUser.LeagueUserTypeEnum.DEFAULT)
                .setCreateTime(LocalDateTime.now());
        leagueUserMapper.insertSelective(leagueUser);
        return prompt("申请成功，等待社团领导审核");
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
                    .setUserId(sessionUser().getId())
                    .setType(LeagueUser.LeagueUserTypeEnum.LEADER));
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

}
