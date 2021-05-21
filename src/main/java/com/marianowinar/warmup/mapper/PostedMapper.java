package com.marianowinar.warmup.mapper;

import com.marianowinar.warmup.dto.response.PostedCreationResponseDto;
import com.marianowinar.warmup.dto.response.PostedResponseDto;
import com.marianowinar.warmup.model.Posted;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;

@Component
public class PostedMapper {

    public Posted toModel(){
        Posted posted = new Posted();
        posted.setDeleted(LocalDate.now());
        return posted;
    }

    public PostedCreationResponseDto toPostedCreationDto(Posted posted) {
        PostedCreationResponseDto dto = new PostedCreationResponseDto();
        dto.setId(posted.getPostedId());
        dto.setUri(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/posted/{id}")
                .buildAndExpand(dto.getId()).toUri());

        return dto;
    }

    public PostedResponseDto toPostedResultDto(Posted posted) {
        PostedResponseDto dto = new PostedResponseDto();
        dto.setPostedId(posted.getPostedId());
        dto.setCategory(posted.getPost().getCategory().getCategory());
        dto.setContent(posted.getPost().getContent());
        dto.setDate(String.valueOf(posted.getDeleted()));
        dto.setImage(posted.getPost().getImage());
        dto.setTitle(posted.getPost().getTitle());
        dto.setUserId(posted.getPost().getUser().getUserId());
        dto.setUsername(posted.getPost().getUser().getUsername());
        dto.setDateDeleted(posted.getDeleted().toString());
        return dto;
    }

    public PostedResponseDto toPostedDto(Posted posted) {
        PostedResponseDto dto = new PostedResponseDto();
        dto.setPostedId(posted.getPostedId());
        dto.setCategory(posted.getPost().getCategory().getCategory());
        dto.setContent(posted.getPost().getContent());
        dto.setDate(String.valueOf(posted.getDeleted()));
        dto.setImage(posted.getPost().getImage());
        dto.setTitle(posted.getPost().getTitle());
        dto.setUserId(posted.getPost().getUser().getUserId());
        dto.setUsername(posted.getPost().getUser().getUsername());
        dto.setDateDeleted(posted.getDeleted().toString());
        return dto;
    }
}
