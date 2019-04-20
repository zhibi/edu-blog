package edu.blog.domain;

import edu.blog.core.base.dto.BaseDomain;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author 执笔
 * @date 2019/4/20 17:02
 */
@Data
@Table(name = "League_user")
public class LeagueUser extends BaseDomain {


    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 社团ID
     */
    private Integer leagueId;
    /**
     * 操作人
     */
    private Integer operationId;

    private LeagueUserTypeEnum type;

    private LeagueUserStatusEnum status;


    public enum LeagueUserStatusEnum {
        /**
         * 申请
         */
        APPLY,
        /**
         * 同意
         */
        AGREE,
        /**
         * 拒绝
         */
        REJECT
    }

    public enum LeagueUserTypeEnum {
        /**
         * 普通用户
         */
        DEFAULT,
        /**
         * 领导
         */
        LEADER
    }
}