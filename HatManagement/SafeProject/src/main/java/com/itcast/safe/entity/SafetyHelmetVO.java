package com.itcast.safe.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SafetyHelmetVO extends SafetyHelmetEntity {

    private String employeeName;
}
