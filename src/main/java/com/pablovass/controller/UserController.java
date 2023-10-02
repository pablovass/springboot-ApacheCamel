package com.pablovass.controller;

import com.pablovass.mapper.UserMapper;
import com.pablovass.model.JsonData;
import com.pablovass.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/crear-usuario")
    public User crearUsuario(@RequestBody JsonData jsonData) {
        return UserMapper.INSTANCE.jsonToUser(jsonData);
    }
}
