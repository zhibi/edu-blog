package edu.blog.core.base.service;

import com.github.pagehelper.PageInfo;
import edu.blog.core.base.dto.BaseDomain;
import edu.blog.core.mybatis.condition.MybatisCondition;

/**
 * 基础service
 * @author  执笔
 * @param <T>
 */
public interface BaseService<T extends BaseDomain> {

    /**
     * 分页
     * @param dto
     * @return
     */
    PageInfo<T> selectPage(T dto);

    /**
     * 分页
     * @param condition
     * @return
     */
    PageInfo<T> selectPage(MybatisCondition condition);

}
