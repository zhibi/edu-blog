package edu.blog.service.impl;

import edu.blog.core.base.service.BaseServiceImpl;
import edu.blog.domain.Tag;
import edu.blog.mapper.TagMapper;
import edu.blog.service.TagService;
import org.springframework.stereotype.Service;

/**
 * @author 执笔
 * @date 2019/4/20 21:37
 */
@Service
public class TagServiceImpl extends BaseServiceImpl<TagMapper, Tag> implements TagService {
}
