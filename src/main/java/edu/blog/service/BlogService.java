package edu.blog.service;


import com.github.pagehelper.PageInfo;
import edu.blog.core.base.service.BaseService;
import edu.blog.core.mybatis.condition.MybatisCondition;
import edu.blog.domain.Blog;
import edu.blog.dto.BlogDTO;

/**
 * 服务类
 *
 * @author 执笔
 * @date 2019-04-20  17:43:03
 */
public interface BlogService extends BaseService<Blog> {
    /**
     * 分页查找博客数据 发布人信息
     *
     * @param condition
     * @return
     */
    PageInfo<BlogDTO> selectDtoPage(MybatisCondition condition);

}