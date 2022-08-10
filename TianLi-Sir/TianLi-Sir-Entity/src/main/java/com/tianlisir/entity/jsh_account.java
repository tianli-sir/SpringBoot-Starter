package com.tianlisir.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class jsh_account {
    private Integer id;
    private String name;
    private Integer serial_no;
    private BigDecimal initial_amount;
    private BigDecimal current_amount;
    private Double is_default;
    private Integer tenant_id;
    private Double delete_flag;
}
