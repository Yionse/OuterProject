package com.itcast.safe.controller;

import com.itcast.safe.common.R;
import com.itcast.safe.entity.LocationInfoEntity;
import com.itcast.safe.service.LocationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locationInfo")
public class LocationInfoController {
    @Autowired
    private LocationInfoService locationInfoService;

    @GetMapping("selectList")
    public R seelctList(){
        List<LocationInfoEntity> list = locationInfoService.list();
        return R.success(list);
    }
}
