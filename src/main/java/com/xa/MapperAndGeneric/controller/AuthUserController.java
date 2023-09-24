package com.xa.MapperAndGeneric.controller;

import com.xa.MapperAndGeneric.dto.authUser.AuthUserCreateDto;
import com.xa.MapperAndGeneric.dto.authUser.AuthUserGetDto;
import com.xa.MapperAndGeneric.dto.authUser.AuthUserUpdateDto;
import com.xa.MapperAndGeneric.service.AuthService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/users/")
public class AuthUserController {

    private final AuthService service;

    public AuthUserController(AuthService service) {
        this.service = service;
    }


    @GetMapping("/get")
    @ResponseBody
    public AuthUserGetDto getUser() {
       return service.list();
    }

//    @GetMapping("get/")
//    public List<AuthUserGetDto> get() {
//        return service.list();
//    }

    @PutMapping("update/")
    public AuthUserGetDto update(@RequestBody AuthUserUpdateDto updateDto){
        return service.update(updateDto);
    }

    @PostMapping("create/")
    public AuthUserGetDto create(@RequestBody AuthUserCreateDto createDto){
        return service.create(createDto);
    }

}
