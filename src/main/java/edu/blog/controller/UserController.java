package edu.blog.controller;

import com.github.pagehelper.PageInfo;
import edu.blog.core.annocation.RequestLogin;
import edu.blog.core.base.controller.BaseController;
import edu.blog.core.mybatis.condition.MybatisCondition;
import edu.blog.domain.Blog;
import edu.blog.mapper.BlogMapper;
import edu.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

/**
 * 前端控制器
 *
 * @author 执笔
 * @date 2019-04-20  17:43:03
 */
@Controller
@RequestMapping("user")
@RequestLogin
public class UserController extends BaseController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogMapper  blogMapper;

    /**
     * 个人中心
     *
     * @return
     */
    @GetMapping("index")
    public String index() {
        return "user/index";
    }

    /**
     * 我的博客
     *
     * @return
     */
    @GetMapping("blogList")
    public String blogList(@RequestParam(defaultValue = "1") int pageNum, Model model) {
        PageInfo<Blog> pageInfo = blogService.selectPage(new MybatisCondition().eq("user_id", sessionUser().getId()).order("id", false).page(pageNum, 20));
        model.addAttribute("pageInfo", pageInfo);
        return "user/blog-list";
    }

    /**
     * 发布博客
     *
     * @return
     */
    @GetMapping("sendBlog")
    public String sendBlog() {
        return "user/blog-input";
    }

    /**
     * 删除博客
     *
     * @param id
     * @return
     */
    @GetMapping("delBlog/{id}")
    public String delBlog(@PathVariable Integer id, RedirectAttributes model) {
        blogMapper.deleteByPrimaryKey(id);
        model.addFlashAttribute(ERROR_MESSAGE, "删除成功");
        return refresh();
    }

    /**
     * 发布博客
     *
     * @param blog
     * @param file
     * @return
     */
    @PostMapping("sendBlog")
    public String sendBlog(Blog blog, MultipartFile file, RedirectAttributes model) {
        if (file != null && !file.isEmpty()) {
            blog.setIcon(saveFile(file));
        } else {
            model.addFlashAttribute(ERROR_MESSAGE, "请选择首图");
            return redirect("/user/blogList");
        }
        blog.setUserId(sessionUser().getId());
        blog.setCreateTime(LocalDateTime.now());
        blogService.send(blog);
        model.addFlashAttribute(ERROR_MESSAGE, "发布成功");
        return redirect("/user/blogList");
    }


}
