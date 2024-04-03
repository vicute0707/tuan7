package com.javademo.service_user.controller;


import com.javademo.service_user.entity.User;
import com.javademo.service_user.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api")
public class ControllerUser {
    @Autowired
    ServiceUser serviceUser;

    @GetMapping("/user")
    public List<User> getALLuser(){
        return serviceUser.getALLUser();
    }
    @PostMapping("/user")
    User addUser(@RequestBody User user){
        return serviceUser.addUser(user);
    }
    @PutMapping("/user")
    User updateUser(@RequestBody User user){
        return serviceUser.updateUser(user);
    }
    @GetMapping("/user/{id}")
    User findByID(@PathVariable Integer id){
        return serviceUser.findById(id);
    }
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id){
        serviceUser.deleteUser(id);
    }


}
