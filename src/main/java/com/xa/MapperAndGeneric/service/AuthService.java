package com.xa.MapperAndGeneric.service;

import com.xa.MapperAndGeneric.dto.AuthUserCreateDto;
import com.xa.MapperAndGeneric.dto.AuthUserGetDto;
import com.xa.MapperAndGeneric.dto.AuthUserUpdateDto;
import com.xa.MapperAndGeneric.dto.BaseDto;
import com.xa.MapperAndGeneric.entity.AuthUser;
import com.xa.MapperAndGeneric.mapper.authUser.AuthUserMapper;
import com.xa.MapperAndGeneric.repository.AuthUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {



    private final AuthUserRepository repository;
    private final AuthUserMapper mapper;
    public AuthService(AuthUserRepository repository, AuthUserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }




    public AuthUserGetDto create(AuthUserCreateDto dto) {
        AuthUser authUser = mapper.fromCreateDto(dto);
        AuthUser result = repository.save(authUser);
        return mapper.fromEntity(result);
    }

    public AuthUserGetDto update(AuthUserUpdateDto dto){

        return mapper.fromEntity(repository.save(mapper.fromUpdateDto(dto)));

    }

    public List<AuthUserGetDto> list() {

       return mapper.fromListEntity(  repository.findAll() );

    }

}
