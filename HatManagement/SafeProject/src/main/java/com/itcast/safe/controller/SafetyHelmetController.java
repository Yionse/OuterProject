package com.itcast.safe.controller;

import com.itcast.safe.common.R;
import com.itcast.safe.entity.EmployeeEntity;
import com.itcast.safe.entity.SafetyHelmetEntity;
import com.itcast.safe.entity.SafetyHelmetVO;
import com.itcast.safe.mapper.SafetyHelmetMapper;
import com.itcast.safe.service.SafetyHelmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/safetyHelmet")
public class SafetyHelmetController {
    @Autowired
    private SafetyHelmetService safetyHelmetService;
    @Autowired
    private SafetyHelmetMapper safetyHelmetMapper;
    @PostMapping("save")
    public R save(@RequestBody SafetyHelmetEntity safetyHelmetEntity){
        safetyHelmetEntity.setUpdateTime(LocalDate.now());
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
        safetyHelmetService.bindSafeHelmet(safetyHelmetEntity);
        return R.success(null);
    }

    @PostMapping("notBind")
    public R noBindSafety(@RequestBody SafetyHelmetEntity safetyHelmetEntity) {
        safetyHelmetMapper.noBind(safetyHelmetEntity.getId());
        return R.success(null);
    }

    @GetMapping("/selectList")
    public R selectList(){
        List<SafetyHelmetVO> list = safetyHelmetService.listSafe();
        return R.success(list);
    }
    @GetMapping("/noSafeHelmetList")
    public R noSafeHelmetList(){
        List<EmployeeEntity> list = safetyHelmetService.noSafetyHelmetService();
        return R.success(list);
    }

}
