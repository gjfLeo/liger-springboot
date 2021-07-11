package com.liger.common.genshin.controller;

import com.liger.common.common.result.ResultResponseBody;
import com.liger.common.genshin.service.GenshinEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResultResponseBody
@RequestMapping(value = "/genshin/event")
public class GenshinEventController {

    @Autowired
    private GenshinEventService genshinEventService;

    @RequestMapping(value = "/list.json")
    public Object list() {
        return genshinEventService.queryEventList();
    }

}
