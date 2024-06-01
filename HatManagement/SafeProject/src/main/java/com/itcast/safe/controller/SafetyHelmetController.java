package com.itcast.safe.controller;

import com.itcast.safe.common.R;
import com.itcast.safe.entity.SafetyHelmetEntity;
import com.itcast.safe.service.SafetyHelmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/safetyHelmet")
public class SafetyHelmetController {
    @Autowired
    private SafetyHelmetService safetyHelmetService;

    @PostMapping("save")
    public R save(@RequestBody SafetyHelmetEntity safetyHelmetEntity){
        safetyHelmetEntity.setCreateTime(LocalDateTime.now());
        safetyHelmetEntity.setUpdateTime(LocalDateTime.now());
        safetyHelmetService.save(safetyHelmetEntity);
        return R.success(null);
    }
    @PostMapping("deleteById")
    public R deleteById(Integer id){
        safetyHelmetService.removeById(id);
        return R.success(null);
    }
    @PostMapping("updateById")
    public R bindSafetyHelmet(@RequestBody SafetyHelmetEntity safetyHelmetEntity){
        safetyHelmetEntity.setUpdateTime(LocalDateTime.now());
        safetyHelmetService.bindSafeHelmet(safetyHelmetEntity);
        return R.success(null);
    }
}
