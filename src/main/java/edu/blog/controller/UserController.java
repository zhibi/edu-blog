package edu.blog.controller;

import com.github.pagehelper.PageInfo;
import edu.blog.core.annocation.RequestLogin;
import edu.blog.core.base.controller.BaseController;
import edu.blog.core.context.Constant;
import edu.blog.core.mybatis.condition.MybatisCondition;
import edu.blog.domain.Blog;
import edu.blog.domain.League;
import edu.blog.domain.User;
import edu.blog.dto.BlogDTO;
import edu.blog.dto.CommentDTO;
import edu.blog.mapper.BlogMapper;
import edu.blog.mapper.CommentMapper;
import edu.blog.mapper.LeagueMapper;
import edu.blog.mapper.UserMapper;
import edu.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 前端控制器
 *
 * @author 执笔
 * @date 2019-04-20  17:43:03
 */
@Controller
@RequestMapping("user")

public class UserController extends BaseController {

    @Autowired
    private BlogService   blogService;
    @Autowired
    private BlogMapper    blogMapper;
    @Autowired
    private UserMapper    userMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private LeagueMapper  leagueMapper;

    /**
     * 个人中心
     *
     * @return
     */
    @GetMapping("index")
    @RequestLogin
    public String index() {
        return "user/index";
    }

    /**
     * 我的博客
     *
     * @return
     */
    @GetMapping("blogList")
    @RequestLogin
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
    @RequestLogin
    public String sendBlog(Model model) {
        model.addAttribute(new Blog());
        return "user/blog-input";
    }

    /**
     * 删除博客
     *
     * @param id
     * @return
     */
    @GetMapping("delBlog/{id}")
    @RequestLogin
    public String delBlog(@PathVariable Integer id, RedirectAttributes model) {
        blogService.delete(id);
        model.addFlashAttribute(ERROR_MESSAGE, "删除成功");
        return refresh();
    }

    /**
     * 博客详情
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("detailBlog/{id}")
    @RequestLogin
    public String detailBlog(@PathVariable Integer id, Model model) {
        Blog blog = blogMapper.selectByPrimaryKey(id);
        model.addAttribute(blog);
        return "user/blog-input";
    }

    /**
     * 发布博客
     *
     * @param blog
     * @param file
     * @return
     */
    @PostMapping("sendBlog")
    @RequestLogin
    public String sendBlog(Blog blog, MultipartFile file, RedirectAttributes model) {
        if (file != null && !file.isEmpty()) {
            blog.setIcon(saveFile(file));
        } else if (blog.getId() == null || blog.getId() <= 0) {
            model.addFlashAttribute(ERROR_MESSAGE, "请选择首图");
            return redirect("/user/blogList");
        }
        blog.setUserId(sessionUser().getId());
        blog.setCreateTime(LocalDateTime.now());
        blogService.send(blog);
        model.addFlashAttribute(ERROR_MESSAGE, "发布成功");
        return redirect("/user/blogList");
    }

    /**
     * 个人详情
     *
     * @return
     */
    @GetMapping("detail")
    @RequestLogin
    public String detail(Model model) {
        User user = userMapper.selectByPrimaryKey(sessionUser().getId());
        model.addAttribute(user);
        return "user/detail";
    }

    /**
     * 更新
     *
     * @return
     */
    @PostMapping("update")
    @RequestLogin
    public String update(User user, MultipartFile file, RedirectAttributes model) {
        if (file != null && !file.isEmpty()) {
            user.setIcon(saveFile(file));
        }
        user.setUpdateTime(LocalDateTime.now());
        userMapper.updateByPrimaryKeySelective(user);
        session.setAttribute(Constant.SESSION_USER, user);
        model.addFlashAttribute(ERROR_MESSAGE, "更新成功");
        return refresh();
    }

    /**
     * 用户主页
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        User user = userMapper.selectByPrimaryKey(id);
        // 博客
        MybatisCondition condition = new MybatisCondition()
                .eq("b.user_id", id)
                .order("b.id", false)
                .page(1, Integer.MAX_VALUE);
        List<BlogDTO> blogList = blogService.selectDtoPage(condition).getList();
        // 用户的社团
        List<League> leagueList = leagueMapper.selectByUser(id);
        // 用户的评论
        List<CommentDTO> commentList = commentMapper.selectDto(new MybatisCondition()
                .eq("c.user_id", id).order("c.id", false));
        model.addAttribute(user);
        model.addAttribute(commentList);
        model.addAttribute(leagueList);
        model.addAttribute(blogList);
        return "user/info";
    }

}
