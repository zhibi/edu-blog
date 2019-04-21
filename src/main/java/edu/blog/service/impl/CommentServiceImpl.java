package edu.blog.service.impl;

import com.github.pagehelper.PageInfo;
import edu.blog.core.base.service.BaseServiceImpl;
import edu.blog.core.mybatis.condition.MybatisCondition;
import edu.blog.domain.Blog;
import edu.blog.domain.Comment;
import edu.blog.dto.CommentDTO;
import edu.blog.mapper.BlogMapper;
import edu.blog.mapper.CommentMapper;
import edu.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 服务实现类
 *
 * @author 执笔
 * @date 2019-04-20  17:43:03
 */
@Service
public class CommentServiceImpl extends BaseServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private BlogMapper    blogMapper;

    @Override
    public PageInfo<CommentDTO> selectDtoPage(MybatisCondition condition) {
        stratPage(condition);
        return new PageInfo<CommentDTO>(commentMapper.selectDto(condition));
    }

    @Override
    public void send(Comment comment) {
        comment.setCreateTime(LocalDateTime.now());
        commentMapper.insertSelective(comment);
        Blog blog = blogMapper.selectByPrimaryKey(comment.getBlogId());
        blog.setCommentNum(blog.getCommentNum() + 1);
        blogMapper.updateByPrimaryKeySelective(blog);
    }
}