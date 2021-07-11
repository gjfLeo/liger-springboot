package com.liger.common.genshin.controller;

import com.liger.common.common.result.Result;
import com.liger.common.common.result.ResultResponseBody;
import com.liger.common.genshin.dto.GenshinVersionDto;
import com.liger.common.genshin.mapper.GenshinVersionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/genshin/version")
@ResultResponseBody
public class GenshinVersionController {


}
