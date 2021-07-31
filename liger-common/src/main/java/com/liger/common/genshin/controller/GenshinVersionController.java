package com.liger.common.genshin.controller;

import com.liger.common.common.result.ResultException;
import com.liger.common.common.result.ResultResponseBody;
import com.liger.common.genshin.entity.GenshinVersionEntity;
import com.liger.common.genshin.service.GenshinVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResultResponseBody
@RequestMapping("/genshin/version")
public class GenshinVersionController {

    @Autowired
    private GenshinVersionService versionService;

    @GetMapping(value = "/list")
    public List<GenshinVersionEntity> list() {
        return versionService.queryVersionList();
    }

    @GetMapping(value = "/info/{version}")
    private GenshinVersionEntity info(@PathVariable String version) {
        GenshinVersionEntity entity = versionService.queryVersion(version);
        if (entity == null) {
            throw new ResultException(HttpStatus.NOT_FOUND, String.format("版本'%s'不存在", version));
        }
        return entity;
    }

}
