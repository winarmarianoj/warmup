package com.marianowinar.warmup.controller;

import com.marianowinar.warmup.dto.request.UserDto;
import com.marianowinar.warmup.dto.response.UserCreationResponseDto;
import com.marianowinar.warmup.security.UserDetailsServiceImpl;
import com.marianowinar.warmup.security.authentication.AuthenticationRequest;
import com.marianowinar.warmup.security.authentication.AuthenticationResponse;
import com.marianowinar.warmup.service.AuthenticationService;
import com.marianowinar.warmup.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AuthenticationControllerTest {

    private AuthenticationController authenticationController;
    private UserDetails userDetails;

    @BeforeEach
    void setUp() {
        AuthenticationService service = mock(AuthenticationService.class);
        UserService userService = mock(UserService.class);
        UserDetailsServiceImpl userDetailsService = mock(UserDetailsServiceImpl.class);
        when(userDetailsService.loadUserByUsername("winarmariano@gmail.com")).thenReturn(userDetails);
        authenticationController = new AuthenticationController(userService, service);
    }

    @Test
    void createAuthenticationToken() throws Exception {
        AuthenticationService service = mock(AuthenticationService.class);
        AuthenticationRequest authenticationRequest = mock(AuthenticationRequest.class);
        when(service.createJwt(authenticationRequest)).thenReturn(new String())
                .thenReturn(String.valueOf(new AuthenticationResponse(service.createJwt(authenticationRequest))));
    }

    @Test
    void postUser() {
        UserDto dto = mock(UserDto.class);
        UserService service = mock(UserService.class);
        when(service.save(dto)).thenReturn(new UserCreationResponseDto());
    }
}