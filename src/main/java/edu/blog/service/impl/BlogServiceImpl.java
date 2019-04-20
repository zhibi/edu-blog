package edu.blog.service.impl;

import com.github.pagehelper.PageInfo;
import edu.blog.core.base.service.BaseServiceImpl;
import edu.blog.core.mybatis.condition.MybatisCondition;
import edu.blog.domain.Blog;
import edu.blog.dto.BlogDTO;
import edu.blog.mapper.BlogMapper;
import edu.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 服务实现类
 *
 * @author 执笔
 * @date 2019-04-20  17:43:03
 */
@Service
public class BlogServiceImpl extends BaseServiceImpl<BlogMapper, Blog> implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public PageInfo<BlogDTO> selectDtoPage(MybatisCondition condition) {
        stratPage(condition);
        return new PageInfo<BlogDTO>(blogMapper.selectDto(condition));
    }
}