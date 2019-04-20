package edu.blog.domain;

import edu.blog.core.base.dto.BaseDomain;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 社团道具
 *
 * @author 执笔
 * @date 2019/4/20 17:02
 */
@Data
@Table(name = "League_Prop")
public class LeagueProp extends BaseDomain {



    /**
     * 社团ID
     */
    private Integer leagueId;
    /**
     * 道具名称
     */
    private String  name;


}