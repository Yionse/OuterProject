package com.itcast.safe.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itcast.safe.entity.SafetyHelmetEntity;
import com.itcast.safe.mapper.SafetyHelmetMapper;
import com.itcast.safe.service.SafetyHelmetService;
import org.springframework.stereotype.Service;

@Service
public class SafetyHelmetServiceImpl extends ServiceImpl<SafetyHelmetMapper, SafetyHelmetEntity> implements SafetyHelmetService {

    @Override
    public void bindSafeHelmet(SafetyHelmetEntity safetyHelmetEntity) {
        LambdaQueryWrapper<SafetyHelmetEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SafetyHelmetEntity::getId,safetyHelmetEntity.getId());
        SafetyHelmetEntity safetyHelmetEntity1 = baseMapper.selectOne(queryWrapper);
        safetyHelmetEntity1.setEmployeeId(safetyHelmetEntity.getEmployeeId());
        baseMapper.updateById(safetyHelmetEntity1);
    }
}
