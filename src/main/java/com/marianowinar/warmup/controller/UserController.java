package com.marianowinar.warmup.controller;

import com.marianowinar.warmup.dto.response.UserResponseDto;
import com.marianowinar.warmup.exception.user.NullUserException;
import com.marianowinar.warmup.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable("id") Long id) throws NullUserException {
        return ResponseEntity.ok(service.findById(id));
    }

    @ResponseBody
    @GetMapping("/username/{username}")
    public ResponseEntity<UserResponseDto> getUserName(@PathVariable("username") String username) {
        return ResponseEntity.ok(service.findByUsername(username));
    }

    @ResponseBody
    @GetMapping("/list")
    public ResponseEntity<List<UserResponseDto>> getUser() {
        return ResponseEntity.ok(service.findAllOrderByUsername());
    }

}
