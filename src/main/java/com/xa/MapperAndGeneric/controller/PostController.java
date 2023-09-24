package com.xa.MapperAndGeneric.controller;

import com.xa.MapperAndGeneric.dto.post.PostCreateDto;
import com.xa.MapperAndGeneric.dto.post.PostGetDto;
import com.xa.MapperAndGeneric.dto.post.PostUpdateDto;
import com.xa.MapperAndGeneric.service.PostService;
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
    public List<PostGetDto> getAll(){
        return service.list();
    }
    @GetMapping("get/{id}")
    public PostGetDto get(@PathVariable Long id){
        return service.get(id);
    }



    @PutMapping("update/")
    public PostGetDto update(@RequestBody PostUpdateDto updateDto){
        return service.update(updateDto);
    }


    @PostMapping("create/")
    public PostGetDto create( @RequestBody PostCreateDto createDto){
        return service.create(createDto);
    }

}
