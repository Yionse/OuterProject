package com.itcast.safe.controller;

import com.itcast.safe.common.R;
import com.itcast.safe.entity.EmployeeEntity;
import com.itcast.safe.entity.WarningInfoEntity;
import com.itcast.safe.entity.WarningInfoVo;
import com.itcast.safe.service.EmployeeService;
import com.itcast.safe.service.WarningInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/warningInfo")
public class WarningInfoController {
    @Autowired
    private WarningInfoService warningInfoService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/selectList")
    public R selectList(){
        List<WarningInfoEntity> list = warningInfoService.list();
        List<WarningInfoVo> voList = new ArrayList<>();
        for (WarningInfoEntity warningInfoEntity : list) {
            EmployeeEntity byId = employeeService.getById(warningInfoEntity.getEmployeeId());
            WarningInfoVo warningInfoVo = new WarningInfoVo();
            BeanUtils.copyProperties(warningInfoEntity,warningInfoVo);
            if (byId != null){
                warningInfoVo.setEmployeeName(byId.getName());
            }
            voList.add(warningInfoVo);
        }
        return R.success(voList);
    }

}
