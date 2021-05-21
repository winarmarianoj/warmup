package com.marianowinar.warmup.service;

import com.marianowinar.warmup.dto.response.PostedCreationResponseDto;
import com.marianowinar.warmup.dto.response.PostedResponseDto;
import com.marianowinar.warmup.exception.post.NullPostException;
import com.marianowinar.warmup.mapper.PostedMapper;
import com.marianowinar.warmup.model.Post;
import com.marianowinar.warmup.model.Posted;
import com.marianowinar.warmup.repository.PostedRepository;
import com.marianowinar.warmup.service.interfaces.IPostedServiceDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostedService implements IPostedServiceDto {

    private PostedRepository postedRepository;
    private PostService postService;
    private PostedMapper postedMapper;

    public PostedService(PostedRepository postedRepository, PostService postService,
                         PostedMapper postedMapper) {
        this.postedRepository = postedRepository;
        this.postService = postService;
        this.postedMapper = postedMapper;
    }

    @Override
    public PostedCreationResponseDto save(Long postedId) throws NullPostException {
        Post post = postService.postFindById(postedId);
        Posted posted = postedMapper.toModel();
        posted.setPost(post);
        postedRepository.save(posted);
        return postedMapper.toPostedCreationDto(posted);
    }

    @Override
    public PostedResponseDto findById(Long id) throws NullPostException {
        Optional<Posted> posted = postedRepository.findById(id);
        if(!posted.isPresent()){
            throw new NullPostException("null post");
        }

        return postedMapper.toPostedResultDto(posted.get());
    }

    @Override
    public List<PostedResponseDto> findAllOrderByDate() {
        return postedRepository.getOrderedByDate().stream().map(u -> postedMapper.toPostedDto(u)).collect(Collectors.toList());
    }

}
