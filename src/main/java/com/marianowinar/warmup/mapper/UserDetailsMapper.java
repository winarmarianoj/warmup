package com.marianowinar.warmup.mapper;

import com.marianowinar.warmup.model.Role;
import com.marianowinar.warmup.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserDetailsMapper {

    public static UserDetails build(User user){
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
    }

    private static Set<? extends GrantedAuthority> getAuthorities(User retrievedUser) {
        Set<Role> roles = retrievedUser.getRoles();
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole().toString())));
        return authorities;
    }
}
