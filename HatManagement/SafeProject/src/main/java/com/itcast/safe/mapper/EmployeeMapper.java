package com.itcast.safe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itcast.safe.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<EmployeeEntity> {
}
