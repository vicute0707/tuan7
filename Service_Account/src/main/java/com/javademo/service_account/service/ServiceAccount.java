package com.javademo.service_account.service;

import com.javademo.service_account.entity.Account;
import com.javademo.service_account.repo.RepoAccount;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceAccount {
    @Autowired
    RepoAccount repoAccount;

    public List<Account> getALLAC(){
        List<Account> list = new ArrayList<>();
        repoAccount.findAll().iterator().forEachRemaining(list::add);

        return list;
    }
    public Account addAC(@RequestBody Account account){
        return repoAccount.save(account);
    }
    public Account findBYid(@PathVariable Integer id){
        return repoAccount.findById(id).get();
    }
    public void deleteAC(@PathVariable Integer id){
        Account account = repoAccount.findById(id).get();
        repoAccount.delete(account);
    }


}
