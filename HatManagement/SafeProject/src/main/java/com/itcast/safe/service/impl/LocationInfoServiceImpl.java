package com.itcast.safe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itcast.safe.entity.LocationInfoEntity;
import com.itcast.safe.mapper.LocationInfoMapper;
import com.itcast.safe.service.LocationInfoService;
import org.springframework.stereotype.Service;

@Service
public class LocationInfoServiceImpl extends ServiceImpl<LocationInfoMapper,LocationInfoEntity> implements LocationInfoService {
}
