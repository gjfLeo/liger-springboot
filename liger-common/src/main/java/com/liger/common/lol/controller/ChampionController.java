package com.liger.common.lol.controller;

import com.liger.common.common.result.Result;
import com.liger.common.lol.entity.ChampionInfoEntity;
import com.liger.common.lol.service.ChampionService;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lol/champion")
public class ChampionController {

    @Autowired
    private ChampionService championService;

    @GetMapping("/main")
    public Result<?> main(String action) {
        if ("updateInfo".equals(StringUtils.defaultIfBlank(action, StringUtils.EMPTY))) {
            return championService.updateChampionInfo();
        }
        if ("updateInfoFull".equals(StringUtils.defaultIfBlank(action, StringUtils.EMPTY))) {
            return championService.updateChampionInfoFull();
        }
        return Result.of(HttpStatus.SC_BAD_REQUEST, "Param 'action' must not be /updateInfo|updateInfoFull");
    }

    @GetMapping("/list")
    public Result<?> list() {
        return Result.ok(championService.getChampionInfoList());
    }

    @GetMapping("/info/{championId}")
    public Result<?> info(@PathVariable String championId, String full) {
        if (!StringUtils.isNumeric(championId)) {
            return Result.of(HttpStatus.SC_NO_CONTENT, String.format("Champion '%s' not exists.", championId));
        }
        ChampionInfoEntity entity = championService.getChampionInfoById(Integer.parseInt(championId), StringUtils.isNotBlank(full));
        if (entity == null) {
            return Result.of(HttpStatus.SC_NO_CONTENT, String.format("Champion '%s' not exists.", championId));
        }
        return Result.ok(entity);
    }

}
