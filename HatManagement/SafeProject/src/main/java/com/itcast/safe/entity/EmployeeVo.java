package com.itcast.safe.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeVo {

    private Integer id;
    private String name;
    private String phoneNumber;
    private String railAddr;
    private LocalDate startTime;
    private LocalDate endTime;

}
