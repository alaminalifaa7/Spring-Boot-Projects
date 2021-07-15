package com.example.Springsecurityregistration.service;

import com.example.Springsecurityregistration.model.User;
import com.example.Springsecurityregistration.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService  extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
