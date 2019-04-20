package edu.blog.mapper;


import edu.blog.core.mybatis.condition.MybatisCondition;
import edu.blog.domain.Blog;
import edu.blog.dto.BlogDTO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 *  Mapper 接口
 *
 * @author 执笔
 * @date 2019-04-20  17:43:03
 */
@org.apache.ibatis.annotations.Mapper
public interface BlogMapper extends Mapper<Blog> {
    /**
     * 根据条件查博客和发布人信息
     * @param condition
     * @return
     */
    List<BlogDTO> selectDto(MybatisCondition condition);
}