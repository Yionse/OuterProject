package com.itcast.safe.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("employees")
public class EmployeeEntity {

    private Integer id;
    private String name;
    @TableField(value = "phone_number")
    private String phoneNumber;
    @TableField(value = "rail_addr")
    private String railAddr;
    @TableField(value = "create_time")
    private LocalDate createTime;
}
