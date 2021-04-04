package com.liger.common.lol.dto.source;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ChampionInfoSourceDto extends BaseSourceDto {

    private HeroSourceDto hero;
    private List<SkinSourceDto> skins;
    private List<SpellSourceDto> spells;

}