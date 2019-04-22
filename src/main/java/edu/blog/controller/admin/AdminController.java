package edu.blog.controller.admin;

import edu.blog.core.base.controller.BaseAdminController;
import edu.blog.core.exception.MessageException;
import edu.blog.core.util.MD5Utils;
import edu.blog.domain.User;
import edu.blog.mapper.UserMapper;
import edu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import zhibi.fast.commons.response.JsonResponse;

/**
 * @author 执笔
 * @date 2019/4/22 11:45
 */
@RequestMapping("admin")
@Controller
public class AdminController extends BaseAdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper  userMapper;

    /**
     * 后台首页
     *
     * @return
     */
    @RequestMapping({"/", "index"})
    public String index() {
        return "admin/index";
    }


    /**
     * 登录页
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "admin/login";
    }

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String username, String password, RedirectAttributes model) {
        User user = userService.checkUser(username, password, User.UserTypeEnum.ADMIN);
        if (null == user) {
            model.addFlashAttribute(ERROR_MESSAGE, "用户名或者密码错误");
            return redirect("/admin/login");
        }
        session.setAttribute(SESSION_ADMIN, user);
        return redirect("/admin/index");
    }

    /**
     * 退出登录
     *
     * @return
     */
    @RequestMapping("logout")
    public String logout() {
        session.removeAttribute(SESSION_ADMIN);
        return redirect("/admin/login");
    }

    /**
     * 修改密码
     *
     * @param password
     * @param pwd
     * @param pwd2
     * @return
     */
    @RequestMapping("modifyPwd")
    @ResponseBody
    public JsonResponse<String> modifyPwd(String password, String pwd, String pwd2) {
        if (!pwd.equals(pwd2)) {
            throw new MessageException("两次密码不一样");
        }
        User user = sessionAdmin();
        user = userMapper.selectByPrimaryKey(user.getId());
        if (!user.getPassword().equalsIgnoreCase(MD5Utils.code(password))) {
            throw new MessageException("原密码不对");
        }
        user.setPassword(MD5Utils.code(pwd));
        userMapper.updateByPrimaryKeySelective(user);
        session.removeAttribute(SESSION_ADMIN);
        return JsonResponse.success("success");
    }

}
