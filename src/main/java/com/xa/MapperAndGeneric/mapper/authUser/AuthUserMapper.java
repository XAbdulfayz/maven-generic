package com.xa.MapperAndGeneric.mapper.authUser;
import com.xa.MapperAndGeneric.dto.authUser.AuthUserCreateDto;
import com.xa.MapperAndGeneric.dto.authUser.AuthUserGetDto;
import com.xa.MapperAndGeneric.dto.authUser.AuthUserUpdateDto;
import com.xa.MapperAndGeneric.entity.AuthUser;
import com.xa.MapperAndGeneric.mapper.GenericMapper;
import com.xa.MapperAndGeneric.mapper.post.PostMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses={PostMapper.class})
public interface AuthUserMapper extends GenericMapper
        <AuthUserCreateDto, AuthUserUpdateDto, AuthUserGetDto, AuthUser> {

}

