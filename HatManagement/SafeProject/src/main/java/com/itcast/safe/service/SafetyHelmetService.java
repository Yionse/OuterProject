package com.itcast.safe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itcast.safe.entity.EmployeeEntity;
import com.itcast.safe.entity.SafetyHelmetEntity;
import com.itcast.safe.entity.SafetyHelmetVO;

import java.util.List;

public interface SafetyHelmetService extends IService<SafetyHelmetEntity> {

    void bindSafeHelmet(SafetyHelmetEntity safetyHelmetEntity);

    List<EmployeeEntity> noSafetyHelmetService();
    List<SafetyHelmetVO> listSafe();
}
