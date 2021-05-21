package com.marianowinar.warmup.service;

import com.marianowinar.warmup.dto.request.PostDto;
import com.marianowinar.warmup.dto.response.PostCreationResponseDto;
import com.marianowinar.warmup.dto.response.PostOrderByDateDto;
import com.marianowinar.warmup.dto.response.PostResponseDto;
import com.marianowinar.warmup.exception.post.NullPostException;
import com.marianowinar.warmup.exception.post.PostException;
import com.marianowinar.warmup.mapper.PostMapper;
import com.marianowinar.warmup.model.Category;
import com.marianowinar.warmup.model.Post;
import com.marianowinar.warmup.model.User;
import com.marianowinar.warmup.repository.PostRepository;
import com.marianowinar.warmup.service.interfaces.IPostServiceDto;
import com.marianowinar.warmup.util.UserConnectedService;
import com.marianowinar.warmup.util.logger.Errors;
import com.marianowinar.warmup.util.validator.ValidPost;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostServiceDto {

    private PostRepository postRepository;
    private ValidPost validPost;
    private Errors errors;
    private PostMapper postMapper;
    private UserConnectedService userConnectedService;
    private CategoryService categoryService;
    private UserService userService;

    public PostService(PostRepository postRepository, ValidPost validPost, Errors errors,
                       PostMapper postMapper, UserConnectedService userConnectedService,
                       CategoryService categoryService, UserService userService) {
        this.postRepository = postRepository;
        this.validPost = validPost;
        this.errors = errors;
        this.postMapper = postMapper;
        this.userConnectedService = userConnectedService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @Override
    public PostCreationResponseDto save(PostDto dto) {
        String username = userConnectedService.userConected();
        User user = userService.userFindByUsername(username);
        Category category = categoryService.categoryFindByCategory(dto.getNameCategory());
        Post post = postMapper.toModel(dto);
        try{
            validPost.validCreatePost(post);
            post.setCategory(category);
            post.setUser(user);
            postRepository.save(post);
        }catch (PostException e){
            errors.logError(e.getError());
        }
        return postMapper.toPostCreationDto(post);
    }

    @Override
    public PostResponseDto patch(Long id, PostDto dto) throws PostException {
        Optional<Post> posted = postRepository.findById(id);
        if(!posted.isPresent())
            throw new NullPostException("Null post. This post not exist.");

        Post post = postMapper.updatePost(posted.get(), dto);
        try {
            validPost.validCreatePost(post);
            postRepository.save(post);
        } catch (PostException e) {
            e.printStackTrace();
        }
        return postMapper.toPostDto(post);
    }

    @Override
    public Post postFindById(Long id) throws NullPostException {
        Optional<Post> post = postRepository.findById(id);
        if(!post.isPresent())
            throw new NullPostException("null post");

        return post.get();
    }

    @Override
    public PostResponseDto findById(Long id) throws NullPostException {
        Optional<Post> post = postRepository.findById(id);
        if(!post.isPresent())
            throw new NullPostException("null post");

        return postMapper.toPostDto(post.get());
    }

    @Override
    public List<PostResponseDto> findAllOrderByTitle(String title) {
        return postRepository.getOrderedByTitle(title).stream().map(u -> postMapper.toPostDto(u)).collect(Collectors.toList());
    }

    @Override
    public List<PostResponseDto> findAllByCategory(String nameCategory) {
        Category category = categoryService.categoryFindByCategory(nameCategory);
        return postRepository.getOrderedByCategoryId(category).stream().map(u -> postMapper.toPostDto(u)).collect(Collectors.toList());
    }

    @Override
    public List<PostOrderByDateDto> findAllOrderByDate() {
        return postRepository.getOrderedByDate().stream().map(u -> postMapper.toPostDateDto(u)).collect(Collectors.toList());
    }

    @Override
    public List<PostResponseDto> findByTitleCategory(String title, String nameCategory) {
        Category category = categoryService.categoryFindByCategory(nameCategory);
        return postRepository.getOrderedByTitleCategoryId(title,category)
                .stream().map(u -> postMapper.toPostDto(u)).collect(Collectors.toList());
    }

}
