package com.marianowinar.warmup.mapper;

import com.marianowinar.warmup.dto.request.PostDto;
import com.marianowinar.warmup.dto.response.PostCreationResponseDto;
import com.marianowinar.warmup.dto.response.PostOrderByDateDto;
import com.marianowinar.warmup.dto.response.PostResponseDto;
import com.marianowinar.warmup.model.Post;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;

@Component
public class PostMapper {

    public Post toModel(PostDto dto){
        Post post = new Post();
        post.setContent(dto.getContent());
        post.setDate(LocalDate.now());
        post.setImage(dto.getImage());
        post.setTitle(dto.getTitle());
        return post;
    }

    public PostCreationResponseDto toPostCreationDto(Post post) {
        PostCreationResponseDto dto = new PostCreationResponseDto();
        dto.setId(post.getPostId());
        dto.setUri(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/post/{id}")
                .buildAndExpand(dto.getId()).toUri());

        return dto;
    }

    public PostResponseDto toPostDto(Post post) {
        PostResponseDto dto = new PostResponseDto();
        dto.setPostId(post.getPostId());
        dto.setCategory(post.getCategory().getCategory());
        dto.setContent(post.getContent());
        dto.setDate(String.valueOf(post.getDate()));
        dto.setImage(post.getImage());
        dto.setTitle(post.getTitle());
        dto.setUserId(post.getUser().getUserId());
        dto.setUsername(post.getUser().getUsername());
        return dto;
    }

    public Post updatePost(Post post, PostDto dto) {
        post.setTitle(dto.getTitle());
        post.setImage(dto.getImage());
        post.setContent(dto.getContent());
        return post;
    }

    public PostOrderByDateDto toPostDateDto(Post post){
        PostOrderByDateDto dto = new PostOrderByDateDto();
        dto.setPostId(post.getPostId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setImage(post.getImage());
        dto.setNameCategory(post.getCategory().getCategory());
        dto.setDate(post.getDate().toString());
        return dto;
    }
}
