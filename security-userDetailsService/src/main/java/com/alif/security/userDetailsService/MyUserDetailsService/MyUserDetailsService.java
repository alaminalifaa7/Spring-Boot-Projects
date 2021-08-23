package com.alif.security.userDetailsService.MyUserDetailsService;

import com.alif.security.userDetailsService.entities.User;
import com.alif.security.userDetailsService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;


public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        Optional<User> user = userRepository.findUserByUsername(username);

        User u = user.orElseThrow(()-> new UsernameNotFoundException("Error"));
        //wrapping a normal user entity with userdetails properties by declaring a securityuser
        // which fulfils the userdetails contracts
        return new SecurityUser(u);

    }
}
