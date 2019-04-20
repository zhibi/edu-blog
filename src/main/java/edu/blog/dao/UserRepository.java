package edu.blog.dao;

import edu.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by limi on 2017/10/15.
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username, String password);
}
