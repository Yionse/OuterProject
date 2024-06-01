package com.itcast.safe.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.itcast.safe.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService extends IService<EmployeeEntity> {

    List<EmployeeEntity> selectList();

    void Save(EmployeeEntity employeeEntity);
}
