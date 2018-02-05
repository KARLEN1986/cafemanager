package com.sfl.repsitory;

import com.sfl.entity.Role;
import com.sfl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Karlen on 05.02.2018.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(final String username);

    List<User> findByRole(final Role role);


}
