package com.itcast.safe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itcast.safe.entity.EmployeeEntity;
import com.itcast.safe.mapper.EmployeeMapper;
import com.itcast.safe.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, EmployeeEntity> implements EmployeeService {


    @Override
    public List<EmployeeEntity> selectList() {
        List<EmployeeEntity> employeeEntities = baseMapper.selectList(null);
        return employeeEntities;
    }

    @Override
    public void Save(EmployeeEntity employeeEntity) {
        baseMapper.insert(employeeEntity);
    }
}
