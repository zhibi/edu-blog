package edu.blog.service.impl;

import com.github.pagehelper.PageInfo;
import edu.blog.core.base.service.BaseServiceImpl;
import edu.blog.core.mybatis.condition.MybatisCondition;
import edu.blog.domain.Blog;
import edu.blog.domain.Tag;
import edu.blog.dto.BlogDTO;
import edu.blog.mapper.BlogMapper;
import edu.blog.mapper.TagMapper;
import edu.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

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
    @Autowired
    private TagMapper  tagMapper;

    @Override
    public PageInfo<BlogDTO> selectDtoPage(MybatisCondition condition) {
        stratPage(condition);
        return new PageInfo<BlogDTO>(blogMapper.selectDto(condition));
    }

    @Override
    public void send(Blog blog) {
        blogMapper.insertSelective(blog);
        Tag tag = tagMapper.selectOne(new Tag().setName(blog.getTag()));
        if (tag == null) {
            tag = new Tag().setName(blog.getTag()).setBlogNum(1);
            tag.setCreateTime(LocalDateTime.now());
            tagMapper.insertSelective(tag);
        } else {
            tag.setBlogNum(tag.getBlogNum() + 1);
            tagMapper.updateByPrimaryKeySelective(tag);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Blog blog = blogMapper.selectByPrimaryKey(id);
        if (null != blog) {
            Tag tag = tagMapper.selectOne(new Tag().setName(blog.getTag()));
            if (tag != null) {
                tag.setBlogNum(tag.getBlogNum() - 1);
                tagMapper.updateByPrimaryKeySelective(tag);
            }
        }
        blogMapper.deleteByPrimaryKey(id);
    }
}