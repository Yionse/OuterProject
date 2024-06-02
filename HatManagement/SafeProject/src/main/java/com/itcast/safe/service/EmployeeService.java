package com.itcast.safe.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.itcast.safe.entity.EmployeeEntity;
import com.itcast.safe.entity.EmployeeVo;

import java.util.List;

public interface EmployeeService extends IService<EmployeeEntity> {

    List<EmployeeEntity> selectList(EmployeeVo employeeVo);
    List<EmployeeEntity> selectListByName(EmployeeVo employeeVo);
    List<EmployeeEntity> selectListStartTime(EmployeeVo employeeVo);
    List<EmployeeEntity> selectListEndTime(EmployeeVo employeeVo);
    List<EmployeeEntity> selectListStartAndEndTime(EmployeeVo employeeVo);
    List<EmployeeEntity> selectListAddress(EmployeeVo employeeVo);
     EmployeeEntity  selectListById(EmployeeVo employeeVo);



    void Save(EmployeeEntity employeeEntity);
}
