package com.liger.common.genshin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liger.common.genshin.dto.GenshinBattlePassDto;
import com.liger.common.genshin.dto.GenshinVersionDto;
import com.liger.common.genshin.entity.GenshinBattlePassEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GenshinBattlePassMapper extends BaseMapper<GenshinBattlePassEntity> {

    List<GenshinBattlePassDto> selectBattlePassList();

}
