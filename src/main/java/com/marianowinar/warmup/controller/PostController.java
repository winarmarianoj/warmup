package com.marianowinar.warmup.controller;

import com.marianowinar.warmup.dto.request.PostDto;
import com.marianowinar.warmup.dto.response.*;
import com.marianowinar.warmup.exception.post.NullPostException;
import com.marianowinar.warmup.exception.post.PostException;
import com.marianowinar.warmup.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> getPost(@PathVariable("id") Long id) throws NullPostException {
        return ResponseEntity.ok(postService.findById(id));
    }

    @ResponseBody
    @GetMapping("/title/{title}")
    public ResponseEntity<List<PostResponseDto>> getAllPostOrderByTitle(@PathVariable("title") String title) {
        return ResponseEntity.ok(postService.findAllOrderByTitle(title));
    }

    @ResponseBody
    @GetMapping("/category/{category}")
    public ResponseEntity<List<PostResponseDto>> getAllPostOrderByCategory(@PathVariable("category") String nameCategory) {
        return ResponseEntity.ok(postService.findAllByCategory(nameCategory));
    }

    @ResponseBody
    @GetMapping("/title/{title}/{nameCategory}") //Todo no logre que funcione el query
    public ResponseEntity<List<PostResponseDto>> getAllPostOrderByTitleCategory(@PathVariable("title") String title,
                                                                                @PathVariable("title") String nameCategory) {
        return ResponseEntity.ok(postService.findByTitleCategory(title,nameCategory));
    }

    @ResponseBody
    @GetMapping("/list")
    public ResponseEntity<List<PostOrderByDateDto>> getAllPostOrderByDate() {
        return ResponseEntity.ok(postService.findAllOrderByDate());
    }

    @ResponseBody
    @PostMapping("/save")
    public ResponseEntity<PostCreationResponseDto> postPosts(
            @RequestBody @Valid PostDto request) {
        PostCreationResponseDto response = postService.save(request);

        return ResponseEntity.created(response.getUri())
                .body(response);
    }

    @ResponseBody
    @PostMapping("/update/{id}")
    public ResponseEntity<PostResponseDto> postPatch(@PathVariable("id") Long id,
            @RequestBody @Valid PostDto request) throws PostException {
        return ResponseEntity.ok(postService.patch(id, request));
    }
}
