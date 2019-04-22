package edu.blog.service.impl;

import edu.blog.core.base.service.BaseServiceImpl;
import edu.blog.domain.League;
import edu.blog.domain.LeagueUser;
import edu.blog.mapper.LeagueMapper;
import edu.blog.mapper.LeagueUserMapper;
import edu.blog.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 服务实现类
 *
 * @author 执笔
 * @date 2019-04-20  17:43:03
 */
@Service
public class LeagueServiceImpl extends BaseServiceImpl<LeagueMapper, League> implements LeagueService {
    @Autowired
    private LeagueUserMapper leagueUserMapper;
    @Autowired
    private LeagueMapper     leagueMapper;

    @Override
    @Transactional
    public void auth(LeagueUser leagueUser) {
        leagueUser.setName("普通成员");
        leagueUserMapper.updateByPrimaryKeySelective(leagueUser);
        if (leagueUser.getStatus() == LeagueUser.LeagueUserStatusEnum.AGREE) {
            League league = leagueMapper.selectByPrimaryKey(leagueUser.getLeagueId());
            league.setUserNum(league.getUserNum() + 1);
            leagueMapper.updateByPrimaryKeySelective(league);
        }
    }

    @Override
    public void quit(Integer leagueId, Integer userId) {
        LeagueUser leagueUser = leagueUserMapper.selectOne(new LeagueUser().setLeagueId(leagueId).setUserId(userId));
        if (null != leagueUser) {
            if (leagueUser.getStatus() == LeagueUser.LeagueUserStatusEnum.AGREE) {
                League league = leagueMapper.selectByPrimaryKey(leagueUser.getLeagueId());
                league.setUserNum(league.getUserNum() - 1);
                leagueMapper.updateByPrimaryKeySelective(league);
            }
            leagueUserMapper.delete(leagueUser);
        }
    }

}