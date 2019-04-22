package edu.blog.service;


import edu.blog.core.base.service.BaseService;
import edu.blog.domain.League;
import edu.blog.domain.LeagueUser;

import java.util.List;

/**
 * 服务类
 *
 * @author 执笔
 * @date 2019-04-20  17:43:03
 */
public interface LeagueService extends BaseService<League> {
    /**
     * 对申请用户操作
     *
     * @param leagueUser
     */
    void auth(LeagueUser leagueUser);

    /**
     * 退出社团
     *
     * @param leagueId
     * @param userId
     */
    void quit(Integer leagueId, Integer userId);

}