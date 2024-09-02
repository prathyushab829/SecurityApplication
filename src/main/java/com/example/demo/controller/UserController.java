package com.example.demo.controller;


import com.example.demo.bean.Users;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    BCryptPasswordEncoder encoder;

    @PostMapping("/register")
    public Users users(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        service.register(user);
        return user;
    }

    @GetMapping("/users")
    public List<Users> users(){
        return service.getUsers();
    }
}
