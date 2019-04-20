package edu.blog.domain;

import edu.blog.core.base.dto.BaseDomain;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author 执笔
 * @date 2019/4/20 16:48
 */
@Data
@Table(name = "blog")
public class Blog extends BaseDomain {


    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;
    /**
     * 标签
     */
    private String flag;
    /**
     * 描述
     */
    private String description;

    /**
     * 发布人
     */
    private Integer userId;
    /**
     * 浏览次数
     */
    private Integer browseNum;
    /**
     * 评论次数
     */
    private Integer commentNum;
    /**
     * 点赞次数
     */
    private Integer startNum;
}
