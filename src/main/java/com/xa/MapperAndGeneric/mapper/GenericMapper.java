package com.xa.MapperAndGeneric.mapper;

import com.xa.MapperAndGeneric.dto.AuthUserCreateDto;
import com.xa.MapperAndGeneric.dto.BaseDto;
import com.xa.MapperAndGeneric.entity.BaseEntity;

import java.util.List;

public interface GenericMapper<CD extends BaseDto, UD extends BaseDto, GD extends BaseDto, E extends BaseEntity> extends BaseMapper{

    E fromCreateDto(CD createDto);
    E fromUpdateDto(UD updateDto);
    GD fromEntity(E entity);

    List<GD> fromListEntity(List<E> entities);

}
