package edu.blog.mapper;


import edu.blog.domain.League;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Mapper 接口
 *
 * @author 执笔
 * @date 2019-04-20  17:43:03
 */
@org.apache.ibatis.annotations.Mapper
public interface LeagueMapper extends Mapper<League> {
    /**
     * 用户的社团
     *
     * @param userId
     * @return
     */
    List<League> selectByUser(Integer userId);

}