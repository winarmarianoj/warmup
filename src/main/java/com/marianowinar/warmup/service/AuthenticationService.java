package com.marianowinar.warmup.service;

import com.marianowinar.warmup.security.UserDetailsServiceImpl;
import com.marianowinar.warmup.security.authentication.AuthenticationRequest;
import com.marianowinar.warmup.util.JwtUtil;
import com.marianowinar.warmup.util.logger.Errors;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private AuthenticationManager authenticationManager;
    private JwtUtil jwtTokenUtil;
    private UserDetailsServiceImpl userDetailsService;

    public AuthenticationService(AuthenticationManager authenticationManager, JwtUtil jwtTokenUtil,
                                 UserDetailsServiceImpl userDetailsService, Errors errors) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    public String createJwt(AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()));
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        return jwtTokenUtil.generateToken(userDetails);
    }
}
