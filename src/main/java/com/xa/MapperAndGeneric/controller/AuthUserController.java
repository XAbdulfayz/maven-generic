package com.xa.MapperAndGeneric.controller;

import com.xa.MapperAndGeneric.dto.authUser.AuthUserCreateDto;
import com.xa.MapperAndGeneric.dto.authUser.AuthUserGetDto;
import com.xa.MapperAndGeneric.dto.authUser.AuthUserUpdateDto;
import com.xa.MapperAndGeneric.response.Data;
import com.xa.MapperAndGeneric.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/users/")
public class AuthUserController {

    private final AuthService service;

    public AuthUserController(AuthService service) {
        this.service = service;
    }


    @GetMapping("/get")
    public ResponseEntity<Data<List<AuthUserGetDto>>> getAll() {
        return new ResponseEntity<>(new Data<>(service.list()), HttpStatus.OK );
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Data<AuthUserGetDto>> get(@PathVariable Long id) {
        return new ResponseEntity<>(new Data<>(service.get(id)), HttpStatus.OK );
    }

    @PutMapping("update/")
    public ResponseEntity<Data<AuthUserGetDto>> update(@RequestBody AuthUserUpdateDto updateDto) {
        return new ResponseEntity<>(new Data<>(service.update(updateDto)), HttpStatus.OK);
    }

    @PostMapping("create/")
    public ResponseEntity<Data<AuthUserGetDto>> create(@RequestBody AuthUserCreateDto createDto) {
        return new ResponseEntity<>(new Data<>(service.create(createDto)), HttpStatus.OK);
    }

}
