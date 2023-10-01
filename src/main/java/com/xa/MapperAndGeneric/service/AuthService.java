package com.xa.MapperAndGeneric.service;

import com.xa.MapperAndGeneric.dto.authUser.AuthUserCreateDto;
import com.xa.MapperAndGeneric.dto.authUser.AuthUserGetDto;
import com.xa.MapperAndGeneric.dto.authUser.AuthUserUpdateDto;
import com.xa.MapperAndGeneric.entity.AuthUser;
import com.xa.MapperAndGeneric.exception.NotFoundException;
import com.xa.MapperAndGeneric.mapper.authUser.AuthUserMapper;
import com.xa.MapperAndGeneric.repository.AuthUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AuthService {



    private final AuthUserRepository repository;
    private final AuthUserMapper mapper;
    public AuthService(AuthUserRepository repository, AuthUserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public AuthUserGetDto get(Long id){
        Optional<AuthUser> result = repository.findById(id);
        if(result.isPresent()) {
            return mapper.fromEntity(result.get());
        }
        throw new NotFoundException("User not found: "+id);
    }

    public AuthUserGetDto create(AuthUserCreateDto dto) {
        AuthUser authUser = mapper.fromCreateDto(dto);
        AuthUser result = repository.save(authUser);
        if (Objects.isNull(result)) {
            throw new RuntimeException("Couldn't create user");
        }
        return mapper.fromEntity(result);
    }

    public AuthUserGetDto update(AuthUserUpdateDto dto){

        Optional<AuthUser> byId = repository.findById(dto.getId());

        return mapper.fromEntity(
                repository.save(
                        mapper.fromUpdateDto(dto, byId.get() )
                )
        );

    }

    public List<AuthUserGetDto> list() {

       return mapper.fromListEntity(  repository.findAll() );

    }

}
