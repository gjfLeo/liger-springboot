package com.liger.local.genshin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liger.common.common.result.Result;
import com.liger.common.common.result.ResultResponseBody;
import com.liger.common.common.util.BatchUtils;
import com.liger.common.genshin.entity.*;
import com.liger.local.genshin.mapper.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.liger.local.genshin.constant.GenshinConstants.ROOT;

@RestController
@ResultResponseBody
@RequestMapping("/updateGenshinData")
public class UpdateGenshinData extends ServiceImpl<GenshinDataTextMapMapper, GenshinDataTextMapEntity> implements IService<GenshinDataTextMapEntity> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateGenshinData.class);
    @Autowired
    private GenshinDataTextMapMapper textMapMapper;
    @Autowired
    private GenshinDataReadableMapper readableMapper;
    @Autowired
    private GenshinDataSubtitleMapper subtitleMapper;
    @Autowired
    private GenshinDataEquipAffixMapper equipAffixMapper;
    @Autowired
    private GenshinDataMaterialMapper materialMapper;

    @RequestMapping("/all")
    public Map<String, Object> all() throws IOException {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("textMap", updateTextMap());
        resultMap.put("readable", readable());
        resultMap.put("subtitle", subtitle());
        resultMap.put("equipAffix", equipAffix());
        return resultMap;
    }

    @RequestMapping("/textMap")
    public Object updateTextMap() throws IOException {
        LOGGER.info("Updating textMap...");
        File file = new File("C:\\Users\\Guo Jifeng\\Documents\\GitHub\\GenshinData\\TextMap\\TextMapCHS.json");
        if (!file.exists()) {
            return Result.error("文件不存在");
        }
        String fileString = FileUtils.readFileToString(file, Charset.defaultCharset());
        JSONObject jsonObject = JSON.parseObject(fileString);

        List<GenshinDataTextMapEntity> dataList = jsonObject.entrySet().stream().parallel()
                .filter(entry -> entry.getValue() != null)
                .filter(entry -> StringUtils.isNotEmpty(entry.getValue().toString()))
                .map(entry -> {
                    GenshinDataTextMapEntity entity = new GenshinDataTextMapEntity();
                    entity.setId(Long.valueOf(entry.getKey()));
                    entity.setText(entry.getValue().toString());
                    return entity;
                }).collect(Collectors.toList());

        textMapMapper.truncate();
        return BatchUtils.groupBatch(dataList, textMapMapper::batchInsert, 1000);
    }

    @RequestMapping("/readable")
    public Object readable() {
        LOGGER.info("Updating readable...");
        File dir = new File("C:\\Users\\Guo Jifeng\\Documents\\GitHub\\GenshinData\\Readable\\CHS");
        if (!dir.exists() || !dir.isDirectory()) {
            return Result.error("目录不存在");
        }

        List<GenshinDataReadableEntity> dataList = Arrays.stream(Objects.requireNonNull(dir.list()))
                .map(filename -> new File(dir, filename))
                .map(file -> {
                    GenshinDataReadableEntity entity = new GenshinDataReadableEntity();
                    entity.setFile(file.getName());
                    try {
                        entity.setContent(FileUtils.readFileToString(file, Charset.defaultCharset()));
                    } catch (IOException e) {
                        LOGGER.error("读文件失败", e);
                    }
                    return entity;
                })
                .collect(Collectors.toList());

        readableMapper.truncate();
        return BatchUtils.groupBatch(dataList, readableMapper::batchReplace, 10);
    }

    @RequestMapping("/subtitle")
    public Object subtitle() {
        LOGGER.info("Updating subtitle...");
        File dir = new File("C:\\Users\\Guo Jifeng\\Documents\\GitHub\\GenshinData\\Subtitle\\CHS");
        if (!dir.exists() || !dir.isDirectory()) {
            return Result.error("目录不存在");
        }

        List<GenshinDataSubtitleEntity> dataList = Arrays.stream(Objects.requireNonNull(dir.list()))
                .map(filename -> new File(dir, filename))
                .map(file -> {
                    GenshinDataSubtitleEntity entity = new GenshinDataSubtitleEntity();
                    entity.setFile(file.getName());
                    try {
                        entity.setContent(FileUtils.readFileToString(file, Charset.defaultCharset()));
                    } catch (IOException e) {
                        LOGGER.error("读文件失败", e);
                    }
                    return entity;
                })
                .collect(Collectors.toList());

        subtitleMapper.truncate();
        return BatchUtils.groupBatch(dataList, subtitleMapper::batchReplace, 10);
    }

    @RequestMapping("/equipAffix")
    public Object equipAffix() throws IOException {
        LOGGER.info("Updating equipAffix...");
        File file = new File(ROOT + "ExcelBinOutput\\EquipAffixExcelConfigData.json");
        JSONArray jsonArray = JSON.parseArray(FileUtils.readFileToString(file, Charset.defaultCharset()));

        List<GenshinDataEquipAffixEntity> dataList = IntStream.range(0, jsonArray.size()).parallel()
                .mapToObj(i -> jsonArray.getObject(i, GenshinDataEquipAffixEntity.class))
                .collect(Collectors.toList());

        equipAffixMapper.truncate();
        return BatchUtils.groupBatch(dataList, equipAffixMapper::batchReplace, 100);
    }

    @RequestMapping("/material")
    public Object material() throws IOException {
        LOGGER.info("Updating material...");
        File file = new File(ROOT + "ExcelBinOutput\\MaterialExcelConfigData.json");
        JSONArray jsonArray = JSON.parseArray(FileUtils.readFileToString(file, Charset.defaultCharset()));

        List<GenshinDataMaterialEntity> dataList = IntStream.range(0, jsonArray.size()).parallel()
                .mapToObj(i -> jsonArray.getObject(i, GenshinDataMaterialEntity.class))
                .collect(Collectors.toList());

        materialMapper.truncate();
        return BatchUtils.groupBatch(dataList, materialMapper::batchReplace, 100);
    }

}
