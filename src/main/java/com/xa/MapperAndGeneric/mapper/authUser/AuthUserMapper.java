package com.xa.MapperAndGeneric.mapper.authUser;

import com.xa.MapperAndGeneric.dto.AuthUserCreateDto;
import com.xa.MapperAndGeneric.dto.AuthUserGetDto;
import com.xa.MapperAndGeneric.dto.AuthUserUpdateDto;
import com.xa.MapperAndGeneric.entity.AuthUser;
import com.xa.MapperAndGeneric.mapper.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthUserMapper extends GenericMapper
        <AuthUserCreateDto, AuthUserUpdateDto, AuthUserGetDto, AuthUser> {



}
