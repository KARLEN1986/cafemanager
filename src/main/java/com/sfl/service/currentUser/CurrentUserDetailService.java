package com.sfl.service.currentUser;


import com.sfl.entity.CurrentUser;
import com.sfl.entity.User;
import com.sfl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/**
 * Created by Karlen on 05.02.2018.
 */
@Service
public class CurrentUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User with email=%S not found", username));

        }
        return new CurrentUser(user);

    }
}
