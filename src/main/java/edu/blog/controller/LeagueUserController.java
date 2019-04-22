package edu.blog.controller;

import edu.blog.core.annocation.RequestLogin;
import edu.blog.core.base.controller.BaseController;
import edu.blog.domain.LeagueUser;
import edu.blog.mapper.LeagueUserMapper;
import edu.blog.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

/**
 * @author 执笔
 * @date 2019/4/22 17:29
 */
@Controller
@RequestMapping("league")
public class LeagueUserController extends BaseController {

    @Autowired
    private LeagueUserMapper leagueUserMapper;
    @Autowired
    private LeagueService    leagueService;

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
     * 退出社团
     *
     * @param leagueId
     * @param userId
     * @return
     */
    @GetMapping("quit/{leagueId}")
    @RequestLogin
    public String quit(@PathVariable Integer leagueId, Integer userId, RedirectAttributes model) {
        if (userId == null || userId <= 0) {
            userId = sessionUser().getId();
        }
        leagueService.quit(leagueId, userId);
        model.addFlashAttribute(ERROR_MESSAGE, "退出成功");
        return refresh();
    }

}
