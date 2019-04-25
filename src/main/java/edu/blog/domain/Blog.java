package edu.blog.domain;

import edu.blog.core.base.dto.BaseDomain;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

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
    @Column(columnDefinition = "text")
    private String content;
    /**
     * 标签
     */
    private String tag;
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

    /**
     * 展示图
     */
    private String icon;

    /**
     * 是否公开
     */
    private Boolean open;
}
