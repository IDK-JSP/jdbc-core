package com.bart.visioback.service;

import com.bart.visioback.daos.UserDao;
import com.bart.visioback.entitys.CustomUserDetails;
import com.bart.visioback.entitys.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserDao userDao;

    public CustomUserDetailsService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        User user = userDao.findByEmail(username);
        return new CustomUserDetails(user);
    }
}
