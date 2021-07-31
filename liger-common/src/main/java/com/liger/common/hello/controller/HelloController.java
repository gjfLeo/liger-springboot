package com.liger.common.hello.controller;

import com.liger.common.common.result.ResultResponseBody;
import com.liger.common.hello.entity.DemoEntity;
import com.liger.common.hello.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResultResponseBody
public class HelloController {

    @Autowired
    private DemoMapper mapper;

    @RequestMapping("/demo")
    public Object d() {
        DemoEntity entity = new DemoEntity();
        entity.setId("1");
        entity.setName("KA");
        return mapper.replace(entity);
    }

}
