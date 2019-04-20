package edu.blog.service.impl;

import edu.blog.core.base.service.BaseServiceImpl;
import edu.blog.core.util.MD5Utils;
import edu.blog.domain.User;
import edu.blog.mapper.UserMapper;
import edu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 服务实现类
 *
 * @author 执笔
 * @date 2019-04-20  17:43:03
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User checkUser(String username, String password, User.UserTypeEnum type) {
        User user = new User();
        user.setType(type);
        user.setUsername(username);
        user.setPassword(MD5Utils.code(password));
        return userMapper.selectOne(user);
    }

    @Override
    public User register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        if (userMapper.select(user).size() > 0) {
            return null;
        }
        user.setName(username);
        user.setPassword(MD5Utils.code(password));
        user.setCreateTime(LocalDateTime.now());
        user.setName(username);
        user.setType(User.UserTypeEnum.USER);
        userMapper.insert(user);
        return user;
    }
}