package com.itcast.safe.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itcast.safe.entity.EmployeeEntity;
import com.itcast.safe.entity.SafetyHelmetEntity;
import com.itcast.safe.entity.SafetyHelmetVO;
import com.itcast.safe.mapper.EmployeeMapper;
import com.itcast.safe.mapper.SafetyHelmetMapper;
import com.itcast.safe.service.EmployeeService;
import com.itcast.safe.service.SafetyHelmetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class SafetyHelmetServiceImpl extends ServiceImpl<SafetyHelmetMapper, SafetyHelmetEntity> implements SafetyHelmetService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<SafetyHelmetVO> listSafe() {
        List<SafetyHelmetEntity> safetyHelmetEntities = baseMapper.selectList(null);
        List<SafetyHelmetVO> list = new ArrayList<>();
        for (SafetyHelmetEntity safetyHelmetEntity : safetyHelmetEntities) {
            Integer employeeId = safetyHelmetEntity.getEmployeeId();
            EmployeeEntity employeeEntity = employeeMapper.selectById(employeeId);
            SafetyHelmetVO safetyHelmetVO = new SafetyHelmetVO();
            BeanUtils.copyProperties(safetyHelmetEntity, safetyHelmetVO);
            if(employeeEntity != null){
                safetyHelmetVO.setEmployeeName(employeeEntity.getName());
            }
            list.add(safetyHelmetVO);
        }
        return list;
    }

    @Override
    public void bindSafeHelmet(SafetyHelmetEntity safetyHelmetEntity) {
        LambdaQueryWrapper<SafetyHelmetEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SafetyHelmetEntity::getId,safetyHelmetEntity.getId());
        SafetyHelmetEntity safetyHelmetEntity1 = baseMapper.selectOne(queryWrapper);
        safetyHelmetEntity1.setEmployeeId(safetyHelmetEntity.getEmployeeId());
        baseMapper.updateById(safetyHelmetEntity1);
    }

    @Override
    public List<EmployeeEntity> noSafetyHelmetService() {
        List<SafetyHelmetEntity> safetyHelmetEntities = baseMapper.selectList(null);
        List<EmployeeEntity> employeesWithoutHelmetRecords = null;
        List<Integer> employeeId = new ArrayList<>();
        for (SafetyHelmetEntity safetyHelmetEntity : safetyHelmetEntities) {
            if (safetyHelmetEntity.getEmployeeId() != null){
                log.info("employee_id为:"+safetyHelmetEntity.getEmployeeId());
                employeeId.add(safetyHelmetEntity.getEmployeeId());
            }
        }
        LambdaQueryWrapper<EmployeeEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.notIn(EmployeeEntity::getId, employeeId);
        if (!CollectionUtils.isEmpty(employeeId)){
            employeesWithoutHelmetRecords = employeeMapper.selectList(queryWrapper);
        }else {
            employeesWithoutHelmetRecords = employeeMapper.selectList(null);

        }
        return employeesWithoutHelmetRecords;

    }
}
