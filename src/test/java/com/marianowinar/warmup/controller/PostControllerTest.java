package com.marianowinar.warmup.controller;

import com.marianowinar.warmup.dto.request.PostDto;
import com.marianowinar.warmup.dto.response.PostCreationResponseDto;
import com.marianowinar.warmup.dto.response.PostResponseDto;
import com.marianowinar.warmup.exception.post.NullPostException;
import com.marianowinar.warmup.exception.post.PostException;
import com.marianowinar.warmup.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PostControllerTest {

    private PostController postController;

    @BeforeEach
    void setup() throws NullPostException {
        PostService service = mock(PostService.class);
        when(service.findById(1L)).thenReturn(new PostResponseDto());
        postController = new PostController(service);
    }

    @Test
    void getPost() throws NullPostException {
        PostService service = mock(PostService.class);
        Long num = Long.valueOf(1);
        when(service.findById(num)).thenReturn(new PostResponseDto());
    }

    @Test
    void getAllPostOrderByTitle(){
        PostService service = mock(PostService.class);
        String title = "Title";
        when(service.findAllOrderByTitle(title)).thenReturn(new ArrayList<>());
    }

    @Test
    void getAllPostOrderByCategory(){
        PostService service = mock(PostService.class);
        String nameCategory = "Sport";
        when(service.findAllByCategory(nameCategory)).thenReturn(new ArrayList<>());
    }

    @Test
    void getAllPostOrderByTitleCategory(){
        PostService service = mock(PostService.class);
        String title = "Programming";
        String nameCategory = "Technology";
        when(service.findByTitleCategory(title,nameCategory)).thenReturn(new ArrayList<>());
    }

    @Test
    void getAllPostOrderByDate(){
        PostService service = mock(PostService.class);
        when(service.findAllOrderByDate()).thenReturn(new ArrayList<>());
    }

    @Test
    void postSave(){
        PostService service = mock(PostService.class);
        PostDto dto = mock(PostDto.class);
        when(service.save(dto)).thenReturn(new PostCreationResponseDto());
    }

    @Test
    void postUpdate() throws PostException {
        PostService service = mock(PostService.class);
        PostDto dto = mock(PostDto.class);
        Long num = Long.valueOf(1);
        when(service.patch(num, dto)).thenReturn(new PostResponseDto());
    }
}
