package edu.blog.mapper;


import edu.blog.core.mybatis.condition.MybatisCondition;
import edu.blog.domain.LeagueUser;
import edu.blog.dto.LeagueUserDTO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Mapper 接口
 *
 * @author 执笔
 * @date 2019-04-20  17:43:03
 */
@org.apache.ibatis.annotations.Mapper
public interface LeagueUserMapper extends Mapper<LeagueUser> {
    /**
     * 社团用户查找
     *
     * @param condition
     * @return
     */
    List<LeagueUserDTO> selectDto(MybatisCondition condition);
}