package com.marianowinar.warmup.service.interfaces;

import com.marianowinar.warmup.dto.request.PostDto;
import com.marianowinar.warmup.dto.response.PostCreationResponseDto;
import com.marianowinar.warmup.dto.response.PostOrderByDateDto;
import com.marianowinar.warmup.dto.response.PostResponseDto;
import com.marianowinar.warmup.exception.post.NullPostException;
import com.marianowinar.warmup.exception.post.PostException;
import com.marianowinar.warmup.model.Post;

import java.util.List;

public interface IPostServiceDto {

    PostCreationResponseDto save(PostDto dto);

    PostResponseDto patch(Long id, PostDto dto) throws PostException;

    Post postFindById(Long id) throws NullPostException;

    PostResponseDto findById(Long id) throws NullPostException;

    List<PostResponseDto> findAllOrderByTitle(String title);

    List<PostResponseDto> findAllByCategory(String nameCategory);

    List<PostOrderByDateDto> findAllOrderByDate();

    List<PostResponseDto> findByTitleCategory(String title, String nameCategory);

}
