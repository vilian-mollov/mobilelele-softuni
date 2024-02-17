package com.softuni.mobilelelesoftuni.services.impl;

import com.softuni.mobilelelesoftuni.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class MobileleleUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MobileleleUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                    .findByUsername(username)
                    .map(this::map)
                    .orElseThrow(() -> new UsernameNotFoundException("User " + username + "mot found!"));
    }

    private UserDetails map(com.softuni.mobilelelesoftuni.models.entities.User user){
        return User
                    .withUsername(user.getUsername())
                    .password(user.getPassword())
                    .authorities(List.of())//todo add roles
                    .build();
    }

}
