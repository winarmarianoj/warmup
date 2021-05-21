package com.marianowinar.warmup.service.interfaces;

import com.marianowinar.warmup.dto.request.UserDto;
import com.marianowinar.warmup.dto.response.UserCreationResponseDto;
import com.marianowinar.warmup.dto.response.UserResponseDto;
import com.marianowinar.warmup.exception.user.NullUserException;
import com.marianowinar.warmup.model.User;

import java.util.List;

public interface IUserServiceDto {

    UserCreationResponseDto save(UserDto dto);

    UserResponseDto findById(Long id) throws NullUserException;

    UserResponseDto findByUsername(String username);

    List<UserResponseDto> findAllOrderByUsername();

    User userFindByUsername(String username);

}
