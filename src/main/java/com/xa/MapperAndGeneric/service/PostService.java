package com.xa.MapperAndGeneric.service;


import com.xa.MapperAndGeneric.dto.authUser.AuthUserCreateDto;
import com.xa.MapperAndGeneric.dto.authUser.AuthUserGetDto;
import com.xa.MapperAndGeneric.dto.post.PostCreateDto;
import com.xa.MapperAndGeneric.dto.post.PostGetDto;
import com.xa.MapperAndGeneric.dto.post.PostUpdateDto;
import com.xa.MapperAndGeneric.entity.AuthUser;
import com.xa.MapperAndGeneric.entity.Post;
import com.xa.MapperAndGeneric.exception.NotFoundException;
import com.xa.MapperAndGeneric.mapper.post.PostMapper;
import com.xa.MapperAndGeneric.repository.AuthUserRepository;
import com.xa.MapperAndGeneric.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PostService {


    private final PostRepository repository;
    private final AuthUserRepository authUserRepository;

    private final PostMapper mapper;


    public PostService(PostRepository repository, AuthUserRepository authUserRepository, PostMapper mapper) {
        this.repository = repository;
        this.authUserRepository = authUserRepository;
        this.mapper = mapper;
    }


    public PostGetDto create(PostCreateDto dto, Long userId) {
        Post post = mapper.fromCreateDto(dto);
        Post result = repository.save(post);

        Optional<AuthUser> resultUser = authUserRepository.findById(userId);
        AuthUser authUser = resultUser.get();
        List<Post> posts = authUser.getPosts();
        posts.add(result);
        authUser.setPosts(posts);
        authUserRepository.save(authUser);
        if (Objects.isNull(result)) {
            throw new RuntimeException("Could not create post");
        }
        return mapper.fromEntity(result);



    }



    public PostGetDto update(PostUpdateDto dto) {

        Optional<Post> byId = repository.findById(dto.getId());

        return mapper.fromEntity(
                repository.save(
                        mapper.fromUpdateDto(dto, byId.get())
                )
        );
    }


    public List<PostGetDto> list() {

        return mapper.fromListEntity(repository.findAll());
    }

    public PostGetDto get(Long id) {
        Optional<Post> result = repository.findById(id);
        if (result.isPresent()) {
            return mapper.fromEntity(result.get());
        }
        throw new NotFoundException("User not found: " + id);
    }


}