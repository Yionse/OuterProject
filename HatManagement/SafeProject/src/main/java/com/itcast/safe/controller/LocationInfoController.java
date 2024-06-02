package com.itcast.safe.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itcast.safe.common.R;
import com.itcast.safe.entity.EmployeeEntity;
import com.itcast.safe.entity.LocationInfoEntity;
import com.itcast.safe.entity.LocationInfoVo;
import com.itcast.safe.entity.SafetyHelmetEntity;
import com.itcast.safe.service.EmployeeService;
import com.itcast.safe.service.LocationInfoService;
import com.itcast.safe.service.SafetyHelmetService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/locationInfo")
public class LocationInfoController {
    @Autowired
    private LocationInfoService locationInfoService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private SafetyHelmetService safetyHelmetService;

    @GetMapping("selectList")
    public R seelctList(){
        List<LocationInfoEntity> list = locationInfoService.list();
        List<LocationInfoVo> locationInfoVos = new ArrayList<>();
        for (LocationInfoEntity locationInfoEntity : list) {
            Integer employeeId = locationInfoEntity.getEmployeeId();
            LambdaQueryWrapper<EmployeeEntity> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(EmployeeEntity::getId,employeeId);
            EmployeeEntity employeeEntity = employeeService.getOne(queryWrapper);
            SafetyHelmetEntity safetyHelmet = safetyHelmetService.getOne(new LambdaQueryWrapper<SafetyHelmetEntity>().eq(SafetyHelmetEntity::getEmployeeId, employeeId));
            LocationInfoVo locationInfoVo = new LocationInfoVo();
            BeanUtils.copyProperties(locationInfoEntity,locationInfoVo);
            if (employeeEntity != null){
                locationInfoVo.setEmployeName(employeeEntity.getName());
            }
            if (safetyHelmet != null){
                locationInfoVo.setSafetyHelmetName(safetyHelmet.getName());
            }
            locationInfoVos.add(locationInfoVo);

        }

        return R.success(locationInfoVos);
    }
}
