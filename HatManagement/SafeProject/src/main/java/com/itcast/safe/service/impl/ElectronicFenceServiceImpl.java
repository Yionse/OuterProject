package com.itcast.safe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itcast.safe.entity.ElectronicFenceEntity;
import com.itcast.safe.mapper.ElectronicFenceMapper;
import com.itcast.safe.service.ElectronicFenceService;
import org.springframework.stereotype.Service;

@Service
public class ElectronicFenceServiceImpl extends ServiceImpl<ElectronicFenceMapper, ElectronicFenceEntity> implements ElectronicFenceService {
}
