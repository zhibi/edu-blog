package edu.blog.service;


import com.github.pagehelper.PageInfo;
import edu.blog.core.base.service.BaseService;
import edu.blog.core.mybatis.condition.MybatisCondition;
import edu.blog.domain.Comment;
import edu.blog.dto.CommentDTO;

/**
 * 服务类
 *
 * @author 执笔
 * @date 2019-04-20  17:43:03
 */
public interface CommentService extends BaseService<Comment> {
    /**
     * 用户评论
     *
     * @param condition
     * @return
     */
    PageInfo<CommentDTO> selectDtoPage(MybatisCondition condition);

    /**
     * 发布评论
     * @param comment
     */
    void send(Comment comment);
}