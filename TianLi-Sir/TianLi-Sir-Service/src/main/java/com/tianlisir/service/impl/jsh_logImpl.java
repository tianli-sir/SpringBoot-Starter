package com.tianlisir.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tianlisir.dao.jsh_logMapper;
import com.tianlisir.entity.jsh_log;
import com.tianlisir.service.Ijsh_log;
import org.springframework.stereotype.Service;

@Service
public class jsh_logImpl extends ServiceImpl<jsh_logMapper, jsh_log> implements Ijsh_log {
}
