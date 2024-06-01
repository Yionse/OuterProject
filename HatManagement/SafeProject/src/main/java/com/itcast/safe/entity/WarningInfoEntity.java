package com.itcast.safe.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("warninginfo")
public class WarningInfoEntity {
    private Integer id;
    @TableField(value = "warning_type")
    private String warningType;
    @TableField(value = "create_time")
    private LocalDateTime createTime;
    @TableField(value = "employee_id")
    private Integer employeeId;
    private String address;
    private Integer result;
}
