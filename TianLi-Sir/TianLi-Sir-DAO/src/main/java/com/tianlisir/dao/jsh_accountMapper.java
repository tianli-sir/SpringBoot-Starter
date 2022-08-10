package com.tianlisir.dao;

import com.tianlisir.entity.jsh_account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface jsh_accountMapper {
    List<jsh_account> getAll();
}
