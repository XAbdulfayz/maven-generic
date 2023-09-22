package com.xa.MapperAndGeneric.dto.post;

import com.xa.MapperAndGeneric.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateDto extends BaseDto {
    private String title;
    private String description;
}
