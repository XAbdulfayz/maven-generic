package com.xa.MapperAndGeneric.mapper.post;

import com.xa.MapperAndGeneric.dto.post.PostCreateDto;
import com.xa.MapperAndGeneric.dto.post.PostGetDto;
import com.xa.MapperAndGeneric.dto.post.PostUpdateDto;
import com.xa.MapperAndGeneric.entity.Post;
import com.xa.MapperAndGeneric.mapper.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper extends GenericMapper<PostCreateDto, PostUpdateDto, PostGetDto, Post> {
}
