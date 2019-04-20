package edu.blog.service.impl;

import edu.blog.service.CommentService;
import edu.blog.domain.Comment;
import edu.blog.mapper.CommentMapper;
import edu.blog.core.base.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author 执笔
 * @date 2019-04-20  17:43:03
 */
@Service
public class CommentServiceImpl extends BaseServiceImpl<CommentMapper, Comment> implements CommentService {
}