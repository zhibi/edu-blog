package edu.blog.dto;

import edu.blog.domain.Comment;
import lombok.Data;

/**
 * @author 执笔
 * @date 2019/4/21 18:16
 */
@Data
public class CommentDTO extends Comment {

    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户头像
     */
    private String userIcon;

    /**
     * 博客标题
     */
    private String blogTitle;
}
