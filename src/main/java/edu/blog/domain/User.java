package edu.blog.domain;

import edu.blog.core.base.dto.BaseDomain;
import lombok.Data;

import javax.persistence.Table;

/**
 * @author 执笔
 * @date 2019/4/20 16:57
 */
@Data
@Table(name = "user")
public class User extends BaseDomain {

    /**
     * 昵称
     */
    private String       name;
    /**
     * 用户名
     */
    private String       username;
    /**
     * 密码
     */
    private String       password;
    private String       email;
    /**
     * 头像
     */
    private String       icon;
    private UserTypeEnum type;

    public enum UserTypeEnum {
        ADMIN, USER
    }
}
