package edu.blog.domain;

import edu.blog.core.base.dto.BaseDomain;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private String userId;
    /**
     * 博客ID
     */
    private String blogId;
    /**
     * 内容
     */
    private String content;
}
