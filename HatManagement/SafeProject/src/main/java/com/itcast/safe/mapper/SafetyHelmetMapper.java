package com.itcast.safe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itcast.safe.entity.SafetyHelmetEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SafetyHelmetMapper extends BaseMapper<SafetyHelmetEntity> {

    void noBind(Integer id);
}
