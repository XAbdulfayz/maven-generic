package com.xa.MapperAndGeneric.dto.post;

import com.xa.MapperAndGeneric.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostGetDto extends BaseDto {

    private Long id;
    private String title;
    private String description;

}
