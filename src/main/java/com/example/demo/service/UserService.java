package com.example.demo.service;

import com.example.demo.bean.Users;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public void register(Users user){
        userRepo.save(user);
    }

    public List<Users> getUsers(){
        return userRepo.findAll();
    }
}
