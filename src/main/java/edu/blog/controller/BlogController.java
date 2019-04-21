package edu.blog.controller;

import edu.blog.core.annocation.RequestLogin;
import edu.blog.core.base.controller.BaseController;
import edu.blog.core.mybatis.condition.MybatisCondition;
import edu.blog.domain.Blog;
import edu.blog.domain.Comment;
import edu.blog.domain.User;
import edu.blog.dto.CommentDTO;
import edu.blog.mapper.BlogMapper;
import edu.blog.mapper.UserMapper;
import edu.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 前端控制器
 *
 * @author 执笔
 * @date 2019-04-20  17:43:03
 */
@Controller
@RequestMapping("blog")
public class BlogController extends BaseController {

    @Autowired
    private BlogMapper     blogMapper;
    @Autowired
    private UserMapper     userMapper;
    @Autowired
    private CommentService commentService;

    /**
     * 博客详情
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Blog blog = blogMapper.selectByPrimaryKey(id);
        User user = userMapper.selectByPrimaryKey(blog.getUserId());
        // 评论信息
        List<CommentDTO> commentList = commentService.selectDtoPage(new MybatisCondition()
                .eq("c.blog_id", id)
                .order("c.id", false)
                .page(1, Integer.MAX_VALUE)).getList();
        model.addAttribute(blog);
        model.addAttribute(user);
        model.addAttribute("commentList", commentList);
        // 更新浏览次数
        blog.setBrowseNum(blog.getBrowseNum() + 1);
        blogMapper.updateByPrimaryKeySelective(blog);
        return "blog";
    }

    /**
     * 评论
     * @param comment
     * @return
     */
    @PostMapping("comment")
    @RequestLogin
    public String comment(Comment comment) {
        comment.setUserId(sessionUser().getId());
        commentService.send(comment);
        return refresh();
    }


}
