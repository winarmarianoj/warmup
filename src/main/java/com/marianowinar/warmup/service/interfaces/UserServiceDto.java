package com.marianowinar.warmup.service.interfaces;

import com.marianowinar.warmup.dto.request.UserDto;
import com.marianowinar.warmup.dto.response.UserCreationResponseDto;
import com.marianowinar.warmup.dto.response.UserResponseDto;
import com.marianowinar.warmup.exception.user.NullUserException;

import java.util.List;

public interface UserServiceDto {

    UserCreationResponseDto save(UserDto dto);

    UserResponseDto findById(Long id) throws NullUserException;

    UserResponseDto findByUsername(String username);

    List<UserResponseDto> findAllOrderByUsername();

}
