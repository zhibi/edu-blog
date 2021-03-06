package edu.blog.domain;

import edu.blog.core.base.dto.BaseDomain;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 执笔
 * @date 2019/4/20 21:20
 */
@Data
@Accessors(chain = true)
public class Tag extends BaseDomain {

    /**
     * 标签名字
     */
    private String name;

    /**
     * 博客数量
     */
    private Integer blogNum;
}
