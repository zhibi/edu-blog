package edu.blog.service.impl;

import edu.blog.service.LeagueService;
import edu.blog.domain.League;
import edu.blog.mapper.LeagueMapper;
import edu.blog.core.base.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author 执笔
 * @date 2019-04-20  17:43:03
 */
@Service
public class LeagueServiceImpl extends BaseServiceImpl<LeagueMapper, League> implements LeagueService {
}