package com.itcast.safe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itcast.safe.entity.SafetyHelmetEntity;

public interface SafetyHelmetService extends IService<SafetyHelmetEntity> {

    void bindSafeHelmet(SafetyHelmetEntity safetyHelmetEntity);
}
