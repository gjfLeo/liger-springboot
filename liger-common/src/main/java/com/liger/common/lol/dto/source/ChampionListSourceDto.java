package com.liger.common.lol.dto.source;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ChampionListSourceDto extends BaseSourceDto {

    private List<HeroSourceDto> hero;

}
