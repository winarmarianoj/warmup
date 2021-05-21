package com.marianowinar.warmup.controller;

import com.marianowinar.warmup.dto.response.PostedCreationResponseDto;
import com.marianowinar.warmup.dto.response.PostedResponseDto;
import com.marianowinar.warmup.exception.post.NullPostException;
import com.marianowinar.warmup.service.PostedService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posted")
public class PostedController {

    private PostedService postedService;

    public PostedController(PostedService postedService) {
        this.postedService = postedService;
    }

    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity<PostedResponseDto> getPosted(@PathVariable("id") Long id) throws NullPostException {
        return ResponseEntity.ok(postedService.findById(id));
    }

    @ResponseBody
    @GetMapping("/list")
    public ResponseEntity<List<PostedResponseDto>> getAllPosted() {
        return ResponseEntity.ok(postedService.findAllOrderByDate());
    }

    @ResponseBody
    @PostMapping("/delete/{id}")
    public ResponseEntity<PostedCreationResponseDto> postPosted(
            @RequestBody @PathVariable("id") Long id) throws NullPostException {
        PostedCreationResponseDto response = postedService.save(id);

        return ResponseEntity.created(response.getUri())
                .body(response);
    }
}
