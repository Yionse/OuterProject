package com.itcast.safe.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("safetyhelmet")
public class SafetyHelmetEntity {

    private Integer id;
    private String number;
    private String name;
    @TableField(value = "create_time")
    private LocalDate createTime;
    @TableField(value = "update_time")
    private LocalDate updateTime;
    @TableField(value = "employee_id")
    private Integer employeeId;
}
