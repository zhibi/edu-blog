package edu.blog.domain;

import edu.blog.core.base.dto.BaseDomain;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 社团
 *
 * @author 执笔
 * @date 2019/4/20 17:00
 */
@Data
@Table(name = "League")
public class League extends BaseDomain {


    /**
     * 社团名字
     */
    private String name;

    /**
     * 人员
     */
    private Integer userNum;

    /**
     * 内容
     */
    @Column(columnDefinition = "text")
    private String content;

    /**
     * 图标
     */
    private String icon;

    /**
     * 联系方式
     */
    private String contact;

    /**
     * 标语
     */
    private String slogan;

}
