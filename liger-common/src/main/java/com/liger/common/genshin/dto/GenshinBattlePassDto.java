package com.liger.common.genshin.dto;

import com.liger.common.genshin.entity.GenshinBattlePassEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class GenshinBattlePassDto extends GenshinBattlePassEntity implements Serializable {

    private Date startDate;

}
