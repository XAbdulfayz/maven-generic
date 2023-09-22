package com.xa.MapperAndGeneric.controller;

import com.xa.MapperAndGeneric.dto.post.PostCreateDto;
import com.xa.MapperAndGeneric.dto.post.PostGetDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post/")
public class PostController {

    @PostMapping("create/{userId}")
    public PostGetDto create(@PathVariable Long userId, @RequestBody PostCreateDto dto){

        return null;
    }

}
