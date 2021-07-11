package com.liger.common.genshin.mapper;

import com.liger.common.genshin.dto.GenshinVersionDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GenshinVersionMapper {

    List<GenshinVersionDto> selectVersionList();

}
