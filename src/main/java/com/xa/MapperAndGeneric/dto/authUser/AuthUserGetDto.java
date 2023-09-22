package com.xa.MapperAndGeneric.dto.authUser;

import com.xa.MapperAndGeneric.dto.BaseDto;
import com.xa.MapperAndGeneric.dto.post.PostGetDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserGetDto extends BaseDto {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String address;
    private String phoneNumber;
    private String gender;
    private String height;
    private String weight;
    private String carNumber;
    private String postalCode;
    private String familyName;

    private List<PostGetDto> posts;

}
