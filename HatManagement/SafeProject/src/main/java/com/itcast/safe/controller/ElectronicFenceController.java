package com.itcast.safe.controller;


import com.itcast.safe.common.R;
import com.itcast.safe.entity.ElectronicFenceEntity;
import com.itcast.safe.service.ElectronicFenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/electronicFence")
public class ElectronicFenceController {
    @Autowired
    private ElectronicFenceService electronicFenceService;

    @GetMapping("selectList")
    public R selectList(){
        List<ElectronicFenceEntity> list = electronicFenceService.list();
        return R.success(list);
    }

}
