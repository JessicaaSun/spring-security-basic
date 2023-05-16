package com.example.springsecuritybasic.service;

import com.example.springsecuritybasic.model.Account;
import com.example.springsecuritybasic.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserServiceDetailsImpl implements UserDetailsService {
    // load user from database
    // inject repository

    private final UserRepository userRepository;
    CustomUserServiceDetailsImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account user = userRepository.findUserByEmail(email);
        UserDetails userDetails = User.builder()
                .username(user.getEmail())
                .password(user.getPasscode())
                .roles(user.getRole())
                .build();
        return userDetails;
    }
}
