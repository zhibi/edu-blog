package edu.blog.mapper;


import edu.blog.core.mybatis.condition.MybatisCondition;
import edu.blog.domain.Comment;
import edu.blog.dto.CommentDTO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Mapper 接口
 *
 * @author 执笔
 * @date 2019-04-20  17:43:03
 */
@org.apache.ibatis.annotations.Mapper
public interface CommentMapper extends Mapper<Comment> {
    /**
     * 用户评论
     *
     * @param condition
     * @return
     */
    List<CommentDTO> selectDto(MybatisCondition condition);
}