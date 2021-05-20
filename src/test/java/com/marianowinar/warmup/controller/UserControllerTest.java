package com.marianowinar.warmup.controller;

import com.marianowinar.warmup.dto.request.UserDto;
import com.marianowinar.warmup.dto.response.UserCreationResponseDto;
import com.marianowinar.warmup.dto.response.UserResponseDto;
import com.marianowinar.warmup.exception.user.NullUserException;
import com.marianowinar.warmup.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserControllerTest {

    private UserController userController;

    @BeforeEach
    void setUp() throws NullUserException {
        UserService service = mock(UserService.class);
        when(service.findById(1L)).thenReturn(new UserResponseDto());
        userController = new UserController(service);
    }

    @Test
    void getUser() throws NullUserException {
        Long num = Long.valueOf(1);
        UserService service = mock(UserService.class);
        when(service.findById(num)).thenReturn(new UserResponseDto());
    }

    @Test
    void getUserName() {
        String names = "win";
        UserService service = mock(UserService.class);
        when(service.findByUsername(names)).thenReturn(new UserResponseDto());
    }

    @Test
    void testGetUser() {
        UserService service = mock(UserService.class);
        when(service.findAllOrderByUsername()).thenReturn(new ArrayList<UserResponseDto>());
    }

}