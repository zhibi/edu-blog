package edu.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import edu.blog.core.base.controller.BaseAdminController;
import edu.blog.core.mybatis.condition.MybatisCondition;
import edu.blog.domain.League;
import edu.blog.mapper.LeagueMapper;
import edu.blog.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

/**
 * @author 执笔
 * @date 2019/4/22 11:45
 */
@Controller
@RequestMapping("/admin/league")
public class AdminLeagueController extends BaseAdminController {

    @Autowired
    private LeagueService leagueService;
    @Autowired
    private LeagueMapper  leagueMapper;

    /**
     * 社团列表
     *
     * @param model
     * @param league
     * @return
     */
    @RequestMapping("list")
    public String list(Model model, League league) {
        MybatisCondition example = new MybatisCondition()
                .like("name", league.getName())
                .page(league);
        PageInfo<League> pageInfo = leagueService.selectPage(example);
        setModelAttribute(model, pageInfo);
        return "admin/league/list";
    }

    /**
     * 社团详情
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        League league = leagueMapper.selectByPrimaryKey(id);
        model.addAttribute(league);
        return "admin/league/update";
    }

    /**
     * 更新社团
     *
     * @param league
     * @return
     */
    @RequestMapping("update")
    public String update(League league) {
        if (league.getId() == null || league.getId() <= 0) {
            league.setCreateTime(LocalDateTime.now());
            leagueMapper.insertSelective(league);
        } else {
            leagueMapper.updateByPrimaryKeySelective(league);
        }
        return redirect("/admin/league/list");
    }

    /**
     * 添加社团
     *
     * @param model
     * @return
     */
    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute(new League());
        return "admin/league/update";
    }

}
