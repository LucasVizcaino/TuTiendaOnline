package com.tutiendaonline.user.service;

import com.tutiendaonline.user.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UsersService extends UserDetailsService {

    Optional<User> registerUser(User user);
    boolean passwordMatches(String rawPassword, String encodedPassword);
}
