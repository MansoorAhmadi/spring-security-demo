package com.example.springsecuritydemo.service;

import com.example.springsecuritydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServices implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return repository.findOneByUsername(username).orElseThrow( () -> {
            throw new UsernameNotFoundException(username);
        });
    }
}
