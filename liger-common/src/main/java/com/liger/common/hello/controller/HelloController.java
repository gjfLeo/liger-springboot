package com.liger.common.hello.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.liger.common.common.result.LigerResult;
import com.liger.common.hello.entity.DemoEntity;
import com.liger.common.hello.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private DemoMapper mapper;

    @GetMapping("/hello")
    public LigerResult<String> hello() {
        return LigerResult.ok("Hello, world! ");
    }

    @GetMapping("/demo")
    @DS("common")
    public LigerResult<DemoEntity> getDemoName() {
        return LigerResult.ok(mapper.selectById("1"));
    }

}
