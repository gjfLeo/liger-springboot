package com.liger.common.genshin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("genshin__data_material")
public class GenshinDataMaterialEntity {

    private Integer id;
    private Integer rank;
    private Integer rankLevel;

    private String itemType;
    private String materialType;

    private Long typeDescTextMapHash;
    private Long nameTextMapHash;
    private Long descTextMapHash;
    private Long interactionTitleTextMapHash;
    private Long effectDescTextMapHash;
    private Long specialDescTextMapHash;

    private String icon;
    private String effectIcon;
    private String effectName;
    private Long effectGadgetId;
    private Long gadgetId;

    private Integer stackLimit;
    private Integer weight;
    private Integer maxUseCount;
    private String useTarget;
    private Integer useLevel;
    private String destroyRule;
    private Integer setId;
    private String foodQuality;
    private Integer cdTime;
    private Integer cdGroup;

    private Boolean isHidden;
    private Boolean playGainEffect;
    private Boolean closeBagAfterUsed;
    private Boolean noFirstGetHint;
    private Boolean isForceGetHint;

}
/*
id
rank
rank_level
item_type
material_type
type_desc_text_map_hash
name_text_map_hash
desc_text_map_hash
interaction_title_text_map_hash
effect_desc_text_map_hash
special_desc_text_map_hash
icon
effect_icon
effect_name
effect_gadget_id
gadget_id
stack_limit
weight
max_use_count
use_target
use_level
destroy_rule
set_id
food_quality
cd_time
cd_group
is_hidden
play_gain_effect
close_bag_after_used
no_first_get_hint
is_force_get_hint
 */