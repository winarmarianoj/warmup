package com.marianowinar.warmup.controller;

import com.marianowinar.warmup.dto.request.UserDto;
import com.marianowinar.warmup.dto.response.UserCreationResponseDto;
import com.marianowinar.warmup.security.authentication.AuthenticationRequest;
import com.marianowinar.warmup.security.authentication.AuthenticationResponse;
import com.marianowinar.warmup.service.AuthenticationService;
import com.marianowinar.warmup.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    private UserService service;
    private AuthenticationService authenticationService;

    public AuthenticationController(UserService service, AuthenticationService authenticationService) {
        this.service = service;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        final String jwt = authenticationService.createJwt(authenticationRequest);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @ResponseBody
    @PostMapping("/sign_up")
    public ResponseEntity<UserCreationResponseDto> postUser(
            @RequestBody @Valid UserDto request) {
        UserCreationResponseDto response = service.save(request);

        return ResponseEntity.created(response.getUri())
                .body(response);
    }

}
