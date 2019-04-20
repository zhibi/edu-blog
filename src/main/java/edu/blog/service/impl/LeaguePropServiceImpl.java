package edu.blog.service.impl;

import edu.blog.service.LeaguePropService;
import edu.blog.domain.LeagueProp;
import edu.blog.mapper.LeaguePropMapper;
import edu.blog.core.base.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author 执笔
 * @date 2019-04-20  17:43:03
 */
@Service
public class LeaguePropServiceImpl extends BaseServiceImpl<LeaguePropMapper, LeagueProp> implements LeaguePropService {
}