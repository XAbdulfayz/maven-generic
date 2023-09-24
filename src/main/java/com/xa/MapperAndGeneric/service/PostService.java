package com.xa.MapperAndGeneric.service;


import com.xa.MapperAndGeneric.dto.post.PostCreateDto;
import com.xa.MapperAndGeneric.dto.post.PostGetDto;
import com.xa.MapperAndGeneric.dto.post.PostUpdateDto;
import com.xa.MapperAndGeneric.entity.Post;
import com.xa.MapperAndGeneric.mapper.post.PostMapper;
import com.xa.MapperAndGeneric.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {


    private final PostRepository repository;

    private final PostMapper mapper;


    public PostService(PostRepository repository, PostMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public PostGetDto create(PostCreateDto dto) {
        Post post = mapper.fromCreateDto(dto);
        Post result = repository.save(post);
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

    public PostGetDto get(Long id){
        Optional<Post> result = repository.findById(id);
        return mapper.fromEntity(result.get());
    }



}
