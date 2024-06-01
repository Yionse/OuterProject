package com.itcast.safe.controller;


import com.itcast.safe.common.R;
import com.itcast.safe.entity.EmployeeEntity;
import com.itcast.safe.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/selectList")
    public R selectList(){
        List<EmployeeEntity> employeeEntities = employeeService.selectList();
        return R.success(employeeEntities);
    }

    @PostMapping("/save")
    public R save(@RequestBody EmployeeEntity employeeEntity){
        employeeEntity.setCreateTime(LocalDateTime.now());
        employeeService.save(employeeEntity);
        return R.success(null);
    }
    @PostMapping("deleteById")
    public R deleteById(Integer id){
        employeeService.removeById(id);
        return R.success(null);
    }
    @PostMapping("updateById")
    public R updateById(@RequestBody EmployeeEntity employeeEntity){
        employeeService.updateById(employeeEntity);
        return R.success(null);
    }

}
