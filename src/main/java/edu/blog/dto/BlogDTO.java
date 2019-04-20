package edu.blog.dto;

import edu.blog.domain.Blog;
import lombok.Data;

/**
 * @author 执笔
 * @date 2019/4/20 21:19
 */
@Data
public class BlogDTO extends Blog {

    /**
     * 发布人
     */
    private String userName;
    /**
     * 发布人头像
     */
    private String userIcon;
}
