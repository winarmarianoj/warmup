package com.marianowinar.warmup.security;

import com.marianowinar.warmup.mapper.UserDetailsMapper;
import com.marianowinar.warmup.model.User;
import com.marianowinar.warmup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepo.findByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("Invalid username or password or user not found");

        return UserDetailsMapper.build(user);
    }

}
