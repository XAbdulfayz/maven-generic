package com.xa.MapperAndGeneric.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AuthUserUpdateDto extends BaseDto{

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

}
