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

    /**
     * Devuelve los datos de un posteo que esta en la Tabla de eliminados
     * Recordar que no son borrados de ningún lugar, solo se anotan así
     * para determinar que fueron eliminados por el usuario
     * @throws NullPostException
     */
    @Test
    void getPosted() throws NullPostException {
        PostedService service = mock(PostedService.class);
        Long num = Long.valueOf(1);
        when(service.findById(num)).thenReturn(new PostedResponseDto());
    }

    /**
     * Devuelve una Lista de los posteos eliminados
     */
    @Test
    void getAllPosted() {
        PostedService service = mock(PostedService.class);
        when(service.findAllOrderByDate()).thenReturn(new ArrayList<>());
    }

    /**
     * Crea un nuevo posteo eliminado en la BD
     * @throws NullPostException
     */
    @Test
    void postPosted() throws NullPostException {
        PostedService service = mock(PostedService.class);
        Long num = Long.valueOf(1);
        when(service.save(num)).thenReturn(new PostedCreationResponseDto());
    }
}