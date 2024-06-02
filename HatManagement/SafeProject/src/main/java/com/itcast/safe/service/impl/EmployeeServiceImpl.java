package com.itcast.safe.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itcast.safe.entity.EmployeeEntity;
import com.itcast.safe.entity.EmployeeVo;
import com.itcast.safe.mapper.EmployeeMapper;
import com.itcast.safe.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, EmployeeEntity> implements EmployeeService {
    @Override
    public List<EmployeeEntity> selectListByName(EmployeeVo employeeVo) {
        LambdaQueryWrapper<EmployeeEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EmployeeEntity::getName,employeeVo.getName());
        List<EmployeeEntity> list = baseMapper.selectList(null);
        return list;
    }

    @Override
    public List<EmployeeEntity> selectListStartTime(EmployeeVo employeeVo) {
        LambdaQueryWrapper<EmployeeEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EmployeeEntity::getCreateTime,employeeVo.getStartTime());
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<EmployeeEntity> selectListEndTime(EmployeeVo employeeVo) {
        LambdaQueryWrapper<EmployeeEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EmployeeEntity::getCreateTime,employeeVo.getEndTime());
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<EmployeeEntity> selectListStartAndEndTime(EmployeeVo employeeVo) {
        LambdaQueryWrapper<EmployeeEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.between(EmployeeEntity::getCreateTime, employeeVo.getStartTime(), employeeVo.getEndTime());
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<EmployeeEntity> selectListAddress(EmployeeVo employeeVo) {
        LambdaQueryWrapper<EmployeeEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EmployeeEntity::getRailAddr,employeeVo.getRailAddr());
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public EmployeeEntity selectListById(EmployeeVo employeeVo) {
        EmployeeEntity employeeEntity = baseMapper.selectById(employeeVo.getId());
        return employeeEntity;
    }



    @Override
    public List<EmployeeEntity> selectList(EmployeeVo employeeVo) {
        LambdaQueryWrapper<EmployeeEntity> queryWrapper = new LambdaQueryWrapper<>();

        // 添加员工编号筛选条件
        if (!StringUtils.isEmpty(employeeVo.getId())) {
            queryWrapper.eq(EmployeeEntity::getId, employeeVo.getId());
        }
        // 添加员工姓名筛选条件
        if (!StringUtils.isEmpty(employeeVo.getName())) {
            queryWrapper.eq(EmployeeEntity::getName, employeeVo.getName());
        }

        if (employeeVo.getStartTime() != null && employeeVo.getEndTime() != null){
            queryWrapper.between(EmployeeEntity::getCreateTime, employeeVo.getStartTime(), employeeVo.getEndTime());
        }else if (employeeVo.getStartTime() != null && employeeVo.getEndTime() == null){
            queryWrapper.ge(EmployeeEntity::getCreateTime, employeeVo.getStartTime());
        }else if (employeeVo.getEndTime() != null && employeeVo.getStartTime() == null){
            queryWrapper.le(EmployeeEntity::getCreateTime, employeeVo.getEndTime());
        }

        // 添加工作地址筛选条件
        if (!StringUtils.isEmpty(employeeVo.getRailAddr())) {
            queryWrapper.eq(EmployeeEntity::getRailAddr, employeeVo.getRailAddr());
        }
        return baseMapper.selectList(queryWrapper);
    }



    @Override
    public void Save(EmployeeEntity employeeEntity) {
        baseMapper.insert(employeeEntity);
    }
}
