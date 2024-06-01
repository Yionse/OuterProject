package com.itcast.safe.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("locationinfo")
public class LocationInfoEntity {

    private Integer id;
    @TableField(value = "hat_id")
    private Integer hatId;
    @TableField(value = "employee_id")
    private Integer employeeId;
    private BigDecimal lon;
    private BigDecimal lat;
    private String addr;
    @TableField(value = "create_time")
    private LocalDateTime createTime;
}
