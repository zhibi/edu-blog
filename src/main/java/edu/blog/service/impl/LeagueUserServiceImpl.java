package edu.blog.service.impl;

import edu.blog.service.LeagueUserService;
import edu.blog.domain.LeagueUser;
import edu.blog.mapper.LeagueUserMapper;
import edu.blog.core.base.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author 执笔
 * @date 2019-04-20  17:43:03
 */
@Service
public class LeagueUserServiceImpl extends BaseServiceImpl<LeagueUserMapper, LeagueUser> implements LeagueUserService {
}