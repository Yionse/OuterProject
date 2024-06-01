package com.itcast.safe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itcast.safe.entity.WarningInfoEntity;
import com.itcast.safe.mapper.WarningInfoMapper;
import com.itcast.safe.service.WarningInfoService;
import org.springframework.stereotype.Service;

@Service
public class WarningInfoServiceImpl extends ServiceImpl<WarningInfoMapper,WarningInfoEntity> implements WarningInfoService {

}
