package com.javademo.service_user.service;

import com.javademo.service_user.entity.Account;
import com.javademo.service_user.entity.User;
import com.javademo.service_user.repo.RepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceUser {
    @Autowired
    RepoUser repouser;
    @Autowired
    RestTemplate restTemplate;

    public List<User> getALLUser(){
        List<User> list = new ArrayList<>();
        repouser.findAll().iterator().forEachRemaining(list::add);
        for (User u:list){
            Account account = restTemplate.getForObject("http://localhost:8091/api/acc/"+u.getId(),Account.class);
            u.setAccount(account);
        }
        return list;
    }
    public User addUser(@RequestBody User user){


        return repouser.save(user);
    }
    @Cacheable(value = "moi")
    public User findById(@PathVariable Integer id){
      User user = repouser.findById(id).get();
      Account account = restTemplate.getForObject("http://localhost:8091/api/acc/"+id,Account.class);
      user.setAccount(account);
       return  user;
    }
    public void deleteUser(@PathVariable Integer id){
        User user = repouser.findById(id).get();
        repouser.delete(user);
    }
    public User updateUser(@RequestBody User user){
        return repouser.save(user);
    }


}
