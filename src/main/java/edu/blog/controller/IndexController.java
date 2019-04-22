package edu.blog.controller;

import com.github.pagehelper.PageInfo;
import edu.blog.core.base.controller.BaseController;
import edu.blog.core.context.Constant;
import edu.blog.core.mybatis.condition.MybatisCondition;
import edu.blog.domain.Blog;
import edu.blog.domain.League;
import edu.blog.domain.Tag;
import edu.blog.domain.User;
import edu.blog.dto.BlogDTO;
import edu.blog.service.BlogService;
import edu.blog.service.LeagueService;
import edu.blog.service.TagService;
import edu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author 执笔
 * @date 2019/4/20 20:40
 */
@Controller
public class IndexController extends BaseController {

    @Autowired
    private BlogService   blogService;
    @Autowired
    private TagService    tagService;
    @Autowired
    private LeagueService leagueService;
    @Autowired
    private UserService   userService;


    /**
     * 首页
     *
     * @param model
     * @return
     */
    @GetMapping({"/", "index"})
    public String index(Model model, String title, @RequestParam(defaultValue = "1") int pageNum) {
        // 博客列表
        MybatisCondition condition = new MybatisCondition()
                .like("b.title", title)
                .eq("b.open", true)
                .order("b.id", false)
                .page(pageNum, 20);
        PageInfo<BlogDTO> blogPageInfo = blogService.selectDtoPage(condition);
        // 标签
        condition = new MybatisCondition()
                .order("blog_num", false)
                .page(1, 12);
        List<Tag> tagList = tagService.selectPage(condition).getList();
        // 社团
        condition = new MybatisCondition()
                .order("user_num", false)
                .page(1, 6);
        List<League> leagueList = leagueService.selectPage(condition).getList();
        // 推荐博客
        condition = new MybatisCondition()
                .order("browse_num", false)
                .page(1, 10);
        List<Blog> blogList = blogService.selectPage(condition).getList();

        model.addAttribute("pageInfo", blogPageInfo);
        model.addAttribute("tagList", tagList);
        model.addAttribute("leagueList", leagueList);
        model.addAttribute("blogList", blogList);
        return "index";
    }


    /**
     * 跳转登录页
     *
     * @return
     */
    @GetMapping("login")
    public String loginPage() {
        return "login";
    }


    /**
     * 登录
     *
     * @param username
     * @param password
     * @param attributes
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        RedirectAttributes attributes) {
        User user = userService.checkUser(username, password, User.UserTypeEnum.USER);
        if (user != null) {
            user.setPassword(null);
            session.setAttribute(Constant.SESSION_USER, user);
            return redirect("/index");
        } else {
            attributes.addFlashAttribute(Constant.ERROR_MESSAGE, "用户名或密码错误");
            return redirect("/login");
        }
    }

    /**
     * 跳转注册页
     *
     * @return
     */
    @GetMapping("register")
    public String register() {
        return "register";
    }

    /**
     * 用户注册
     *
     * @param username
     * @param password
     * @param password2
     * @param model
     * @return
     */
    @PostMapping("register")
    public String register(String username, @RequestParam(defaultValue = "") String password, String password2,
                           RedirectAttributes model) {
        if (!password.equals(password2)) {
            model.addFlashAttribute(ERROR_MESSAGE, "两次密码不一样");
            return redirect("/register");
        }
        if (username == null || "".equals(username)) {
            model.addFlashAttribute(ERROR_MESSAGE, "用户名不能为空");
            return redirect("/register");
        }
        User user = userService.register(username, password);
        if (null == user) {
            model.addFlashAttribute(ERROR_MESSAGE, "用户名已经存在了");
            return redirect("/register");
        }
        model.addFlashAttribute(ERROR_MESSAGE, "注册成功");
        return redirect("/login");
    }

    /**
     * 退出登录
     *
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute(Constant.SESSION_USER);
        return "redirect:/";
    }
}

