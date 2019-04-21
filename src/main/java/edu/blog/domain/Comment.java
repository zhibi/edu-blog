package edu.blog.domain;

import edu.blog.core.base.dto.BaseDomain;
import lombok.Data;

import javax.persistence.Table;

/**
 * @author 执笔
 * @date 2019/4/20 16:54
 */
@Data
@Table(name = "comment")
public class Comment extends BaseDomain {


    /**
     * 评论人
     */
    private Integer userId;
    /**
     * 博客ID
     */
    private Integer  blogId;
    /**
     * 内容
     */
    private String  content;
}
