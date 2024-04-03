package com.javademo.service_account.controller;

import com.javademo.service_account.entity.Account;
import com.javademo.service_account.service.ServiceAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/api")
public class ControllerAccount {
    @Autowired
    ServiceAccount serviceAccount;
    @GetMapping("/acc")
    public List<Account> getALLACC(){
        return serviceAccount.getALLAC();
    }
    @GetMapping("acc/{id}")
    public Account findBYid(@PathVariable Integer id){
        return serviceAccount.findBYid(id);
    }
    @PostMapping("/acc")
    public Account addAC(@RequestBody Account acc){
        return serviceAccount.addAC(acc);
    }
    @DeleteMapping("/acc/{id}")
    public String deleteAC(@PathVariable Integer id){
        serviceAccount.deleteAC(id);
        return "Xoa thanh cong";
    }
}
