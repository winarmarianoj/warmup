package com.marianowinar.warmup.mapper;

import com.marianowinar.warmup.dto.request.UserDto;
import com.marianowinar.warmup.dto.response.UserCreationResponseDto;
import com.marianowinar.warmup.dto.response.UserResponseDto;
import com.marianowinar.warmup.model.Role;
import com.marianowinar.warmup.model.User;
import com.marianowinar.warmup.model.enums.RoleName;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserMapper {

    public User toModel(UserDto dto, Role role){
        User user = new User();
        user.setUsername(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setEnabled(true);

        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);

        return user;
    }

    public UserCreationResponseDto toUserCreationDto(User user) {
        UserCreationResponseDto dto = new UserCreationResponseDto();
        dto.setId(user.getUserId());
        dto.setUri(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/user/{id}")
                .buildAndExpand(dto.getId()).toUri());

        return dto;
    }

    public UserResponseDto toUserDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());

        return dto;
    }

}
