package com.marianowinar.warmup.service.interfaces;

import com.marianowinar.warmup.dto.response.PostedCreationResponseDto;
import com.marianowinar.warmup.dto.response.PostedResponseDto;
import com.marianowinar.warmup.exception.post.NullPostException;

import java.util.List;

public interface IPostedServiceDto {

    PostedCreationResponseDto save(Long postedId) throws NullPostException;

    PostedResponseDto findById(Long id) throws NullPostException;

    List<PostedResponseDto> findAllOrderByDate();
}
