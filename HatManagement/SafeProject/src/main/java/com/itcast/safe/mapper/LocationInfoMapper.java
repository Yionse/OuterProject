package com.itcast.safe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itcast.safe.entity.LocationInfoEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LocationInfoMapper extends BaseMapper<LocationInfoEntity> {
}
