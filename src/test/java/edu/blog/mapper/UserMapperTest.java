package edu.blog.mapper;

import edu.blog.core.util.MD5Utils;
import edu.blog.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * @author 执笔
 * @date 2019/4/20 21:22
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback
    public void testInsert() {
        User user = new User();
        user.setUsername("admin");
        user.setType(User.UserTypeEnum.ADMIN);
        user.setPassword(MD5Utils.code("1234"));
        userMapper.insertSelective(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1);
        user.setName("超级管理员");
        user.setCreateTime(LocalDateTime.now());
        userMapper.updateByPrimaryKeySelective(user);
    }
}