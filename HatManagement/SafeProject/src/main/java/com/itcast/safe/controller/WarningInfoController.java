package com.itcast.safe.controller;

import com.itcast.safe.common.R;
import com.itcast.safe.entity.WarningInfoEntity;
import com.itcast.safe.service.WarningInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/warningInfo")
public class WarningInfoController {
    @Autowired
    private WarningInfoService warningInfoService;

    @GetMapping("/selectList")
    public R selectList(){
        List<WarningInfoEntity> list = warningInfoService.list();
        return R.success(list);
    }

}
