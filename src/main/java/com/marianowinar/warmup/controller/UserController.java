package com.marianowinar.warmup.controller;

import com.marianowinar.warmup.dto.request.UserDto;
import com.marianowinar.warmup.dto.response.UserCreationResponseDto;
import com.marianowinar.warmup.dto.response.UserResponseDto;
import com.marianowinar.warmup.exception.user.NullUserException;
import com.marianowinar.warmup.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<UserResponseDto> getUser(@PathVariable("username") String username) {
        return ResponseEntity.ok(service.findByUsername(username));
    }

    @ResponseBody
    @GetMapping("/list")
    public ResponseEntity<List<UserResponseDto>> getUser() {
        return ResponseEntity.ok(service.findAllOrderByUsername());
    }

    @ResponseBody
    @PostMapping("/save")
    public ResponseEntity<UserCreationResponseDto> postUser(
            @RequestBody @Valid UserDto request) {
        UserCreationResponseDto response = service.save(request);

        return ResponseEntity.created(response.getUri())
                .body(response);
    }

}
