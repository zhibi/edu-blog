package edu.blog.service;


import edu.blog.core.base.service.BaseService;
import edu.blog.domain.User;

/**
 * 服务类
 *
 * @author 执笔
 * @date 2019-04-20  17:43:03
 */
public interface UserService extends BaseService<User> {
    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @param type
     * @return
     */
    User checkUser(String username, String password, User.UserTypeEnum type);

    /**
     * 用户注册
     *
     * @param username
     * @param password
     * @return
     */
    User register(String username, String password);
}