package com.marianowinar.warmup.controller;

import com.marianowinar.warmup.dto.response.PostedCreationResponseDto;
import com.marianowinar.warmup.dto.response.PostedResponseDto;
import com.marianowinar.warmup.exception.post.NullPostException;
import com.marianowinar.warmup.service.PostedService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PostedControllerTest {

    private PostedController postedController;

    @BeforeEach
    void setUp() throws NullPostException {
        PostedService service = mock(PostedService.class);
        when(service.findById(1L)).thenReturn(new PostedResponseDto());
        postedController = new PostedController(service);
    }

    @Test
    void getPosted() throws NullPostException {
        PostedService service = mock(PostedService.class);
        Long num = Long.valueOf(1);
        when(service.findById(num)).thenReturn(new PostedResponseDto());
    }

    @Test
    void getAllPosted() {
        PostedService service = mock(PostedService.class);
        when(service.findAllOrderByDate()).thenReturn(new ArrayList<>());
    }

    @Test
    void postPosted() throws NullPostException {
        PostedService service = mock(PostedService.class);
        Long num = Long.valueOf(1);
        when(service.save(num)).thenReturn(new PostedCreationResponseDto());
    }
}