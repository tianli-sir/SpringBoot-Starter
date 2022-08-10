package com.tianlisir.controller;

import com.tianlisir.entity.jsh_account;
import com.tianlisir.service.Ijsh_account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
public class jsh_accountController {

    @Autowired
    Ijsh_account ijsh_account;
    @GetMapping("/{id}")
    //@PathVariable 获取路径值
    public void GetAll(@PathVariable Integer id){
        List<jsh_account> all = ijsh_account.getAll();
        System.out.println(all);
        System.out.println(id);
    }
}
