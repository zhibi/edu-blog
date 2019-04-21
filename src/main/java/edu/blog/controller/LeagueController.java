package edu.blog.controller;

import edu.blog.core.annocation.RequestLogin;
import edu.blog.core.base.controller.BaseController;
import edu.blog.domain.League;
import edu.blog.domain.LeagueUser;
import edu.blog.mapper.LeagueMapper;
import edu.blog.mapper.LeagueUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
