package com.xa.MapperAndGeneric.service;

import com.xa.MapperAndGeneric.dto.AuthUserCreateDto;
import com.xa.MapperAndGeneric.dto.AuthUserGetDto;
import com.xa.MapperAndGeneric.entity.AuthUser;
import com.xa.MapperAndGeneric.mapper.authUser.AuthUserMapper;
import com.xa.MapperAndGeneric.repository.AuthUserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService {

    private final AuthUserRepository repository;
    private final AuthUserMapper mapper;


    public AuthUserService(AuthUserRepository repository, AuthUserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public AuthUserGetDto create(AuthUserCreateDto dto){
        AuthUser authUser = mapper.fromCreateDto(dto);
        AuthUser result = repository.save(authUser);
        return mapper.fromEntity(result);
    }




}
