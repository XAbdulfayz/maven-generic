package com.xa.MapperAndGeneric.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AuthUser extends BaseEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(fetch = FetchType.EAGER)
    private List<Post> posts;

}
