package edu.blog.dto;

import edu.blog.domain.LeagueUser;
import lombok.Data;

/**
 * @author 执笔
 * @date 2019/4/21 21:20
 */
@Data
public class LeagueUserDTO extends LeagueUser {

    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户头像
     */
    private String userIcon;
}
