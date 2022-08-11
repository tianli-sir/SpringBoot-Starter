package com.tianlisir.entity;

import lombok.Data;

@Data
public class jsh_log {
    private Integer id;
    private Integer user_id;
    private String operation;
    private String client_ip;
    private String create_time;
    private Boolean status;
    private String content;
    private Integer tenant_id;
}
