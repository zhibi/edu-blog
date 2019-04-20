package edu.blog.mapper;


import edu.blog.domain.User;
import tk.mybatis.mapper.common.Mapper;

/**
 *  Mapper 接口
 *
 * @author 执笔
 * @date 2019-04-20  17:43:03
 */
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {
}