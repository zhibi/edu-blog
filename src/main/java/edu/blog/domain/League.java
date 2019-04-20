package edu.blog.domain;

import edu.blog.core.base.dto.BaseDomain;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 社团
 *
 * @author 执笔
 * @date 2019/4/20 17:00
 */
@Data
@Table(name = "League")
public class League extends BaseDomain {


    /**
     * 社团名字
     */
    private String name;

}
