package com.xa.MapperAndGeneric.controller;

import com.xa.MapperAndGeneric.dto.post.PostCreateDto;
import com.xa.MapperAndGeneric.dto.post.PostGetDto;
import com.xa.MapperAndGeneric.dto.post.PostUpdateDto;
import com.xa.MapperAndGeneric.response.Data;
import com.xa.MapperAndGeneric.service.PostService;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post/")
public class PostController {


    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }


    @GetMapping("get/")
    public ResponseEntity<Data<List<PostGetDto>>> getAll() {
        return new ResponseEntity<>(new Data<>(service.list()), HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Data<PostGetDto>> get(@PathVariable Long id) {
        return new ResponseEntity<>(new Data<>(service.get(id)), HttpStatus.OK);
    }


    @PutMapping("update/")
    public ResponseEntity<Data<PostGetDto>> update(@RequestBody PostUpdateDto updateDto) {
        return new ResponseEntity<>(new Data<>(service.update(updateDto)), HttpStatus.OK);
    }


    @PostMapping("create/{userId}")
    public ResponseEntity<Data<PostGetDto>> create(@PathVariable Long userId, @RequestBody PostCreateDto createDto) {
        return new ResponseEntity<>(new Data<>(service.create(createDto, userId)), HttpStatus.OK);
    }

}
