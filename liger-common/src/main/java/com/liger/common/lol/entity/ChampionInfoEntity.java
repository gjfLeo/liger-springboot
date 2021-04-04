package com.liger.common.lol.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("champion_info")
public class ChampionInfoEntity {

    /** 英雄ID */
    @TableId(type = IdType.INPUT)
    private Integer championId;
    /** 名字 */
    private String name;
    /** 称号 */
    private String title;
    /** 英文名字 */
    private String nameEn;
    /** 英文称号 */
    private String titleEn;
    /** 称呼，以英文逗号分隔 */
    private String alias;

    /** 分类，以英文逗号分隔 */
    private String classes;

    /** 物理攻击 评分(1~10) */
    private Integer attackScore;
    /** 魔法攻击 评分(1~10) */
    private Integer magicScore;
    /** 防御能力 评分(1~10) */
    private Integer defenceScore;
    /** 上手难度 评分(1~10) */
    private Integer difficultyScore;

    /** 金币价格 */
    private Integer goldPrice;
    /** 点券价格 */
    private Integer couponPrice;

    /** 剧情简介 */
    private String shortBio;

    /** 伤害类型 */
    private Integer damageType;
    /** 伤害风格 */
    private Integer damageStyle;

    /** 难度 等级(1~3) **/
    private Integer difficultyLevel;
    /** 伤害 等级(1~3) **/
    private Integer damageLevel;
    /** 强韧 等级(1~3) **/
    private Integer durabilityLevel;
    /** 控制 等级(1~3) **/
    private Integer crowdControlLevel;
    /** 机动 等级(1~3) **/
    private Integer mobilityLevel;
    /** 功能 等级(1~3) **/
    private Integer utilityLevel;

}
