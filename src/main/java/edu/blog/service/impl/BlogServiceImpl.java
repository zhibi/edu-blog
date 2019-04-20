package edu.blog.service.impl;

import edu.blog.service.BlogService;
import edu.blog.domain.Blog;
import edu.blog.mapper.BlogMapper;
import edu.blog.core.base.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author 执笔
 * @date 2019-04-20  17:43:03
 */
@Service
public class BlogServiceImpl extends BaseServiceImpl<BlogMapper, Blog> implements BlogService {
}