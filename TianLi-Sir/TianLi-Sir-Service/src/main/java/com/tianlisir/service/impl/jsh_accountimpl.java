package com.tianlisir.service.impl;

import com.tianlisir.dao.jsh_accountMapper;
import com.tianlisir.entity.jsh_account;
import com.tianlisir.service.Ijsh_account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class jsh_accountimpl implements Ijsh_account {

    @Autowired
    jsh_accountMapper accountMapper;

    @Override
    public List<jsh_account> getAll() {
        return accountMapper.getAll();
    }
}
