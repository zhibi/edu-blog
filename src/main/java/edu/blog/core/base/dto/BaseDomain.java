package edu.blog.core.base.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.LocalDateTime;

/**
 * 分页 基础信息
 *
 * @author 执笔
 */
@Getter
@Setter
public abstract class BaseDomain {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer       id;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    @Transient
    private Integer pageNum = 0;
    @Transient
    private Integer pageSize = 10;
}
