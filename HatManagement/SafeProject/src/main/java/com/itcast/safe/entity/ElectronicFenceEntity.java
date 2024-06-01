package com.itcast.safe.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("electronicfence")
public class ElectronicFenceEntity {
    private Integer id;
    @TableField(value = "rail_id")
    private Integer railId;
    @TableField(value = "rail_addr")
    private String railAddr;
    @TableField(value = "rail_num")
    private Integer railNum;
    @TableField(value = "rail_lon")
    private BigDecimal railLon;
    @TableField(value = "rail_lat")
    private BigDecimal railLat;
    @TableField(value = "create_time")
    private LocalDateTime createTime;
    @TableField(value = "job_caption")
    private String jobCaption;
    @TableField(value = "phone_number")
    private String phoneNumber;
    private Integer finished;

}
