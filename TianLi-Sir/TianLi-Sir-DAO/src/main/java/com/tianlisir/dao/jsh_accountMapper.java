package com.tianlisir.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianlisir.entity.jsh_account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface jsh_accountMapper extends BaseMapper<jsh_account> {
    List<jsh_account> getAll();
}
