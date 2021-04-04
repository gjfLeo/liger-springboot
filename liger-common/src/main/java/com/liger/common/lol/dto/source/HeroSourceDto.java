package com.liger.common.lol.dto.source;

import com.liger.common.lol.constant.DamageType;
import com.liger.common.lol.constant.HeroClass;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
@Data
public class HeroSourceDto {

    /** 英雄ID */
    private String heroId;              //"1"
    /** 称号 */
    private String name;                //"黑暗之女"
    /** 英文名字 */
    private String alias;               //"Annie"
    /** 名字 */
    private String title;               //"安妮"
    /** 分类 每项是{@link HeroClass} */
    private List<String> roles;         //["mage"]
    /** 物理攻击评分（1~10） */
    private String attack;              //"2"
    /** 防御能力评分（1~10） */
    private String defense;             //"3"
    /** 魔法攻击评分（1~10） */
    private String magic;               //"10"
    /** 上手难度评分（1~10） */
    private String difficulty;          //"6"

    /** 改动标签 */
    private String changeLabel;         //"无改动"
    /** 精粹价格 */
    private String goldPrice;           //"4800"
    /** 点券价格 */
    private String couponPrice;         //"2000"
    private String camp;                //""
    private String campId;              //""
    /** 名字关键词 */
    private String keywords;            //"安妮,黑暗之女,火女,Annie,anni,heianzhinv,huonv,an,hazn,hn"
    /** 剧情简介 */
    private String shortBio; // "即使是在秘密团体黑色玫瑰的成员内部，乐芙兰也同样保持神秘，而乐芙兰这个名字也只是众多化名之一。这个皮肤惨白的女人自从诺克萨斯建国初期就开始操纵大小人物，推动事态发展。这位女法师能用魔法制造自己的镜像，她可以出现在任何地点、任何人面前、甚至同时现身于许多地方。乐芙兰永远都在暗处密谋策划，而她真正的动机和她变换不定的身份一样令人难以捉摸。"

    private String selectAudio;         //"https://game.gtimg.cn/images/lol/act/img/vo/choose/1.ogg"
    private String banAudio;            //"https://game.gtimg.cn/images/lol/act/img/vo/ban/1.ogg"
    private String isWeekFree;          //"0"
    private String isARAMweekfree;      //"0"
    private String ispermanentweekfree; //"0"

    private String hp; // "528.0000"
    private String hpperlevel; // "97.0000"
    private String mp; // "334.0000"
    private String mpperlevel; // "50.0000"
    private String movespeed; // "340.0000"
    private String armor; // "22.0000"
    private String armorperlevel; // "3.5000"
    private String spellblock; // "30.0000"
    private String spellblockperlevel; // "0.5000"
    private String attackrange; // "525.0000"
    private String hpregen; // "7.5000"
    private String hpregenperlevel; // "0.5500"
    private String mpregen; // "6.0000"
    private String mpregenperlevel; // "0.8000"
    private String crit; // "0.0000"
    private String critperlevel; // "0.0000"
    private String attackdamage; // "55.0000"
    private String attackdamageperlevel; // "3.5000"
    private String attackspeed; // "0.6250"
    private String attackspeedperlevel; // "1.4000"

    private List<String> allytips;
    private List<String> enemytips;

    /** 伤害类型 {@link DamageType#getKey()} */
    private String damageType; // "kMagic",
    /** 风格（0普攻~10技能） */
    private String style; // "10",
    /** 难度（0~3） */
    private String difficultyL; // "3",
    /** 伤害评分（0~3） */
    private String damage; // "3",
    /** 强韧评分（0~3） */
    private String durability; // "1",
    /** 控制评分（0~3） */
    private String crowdControl; // "2",
    /** 机动评分（0~3） */
    private String mobility; // "3",
    /** 功能评分（0~3） */
    private String utility; // "1",

    private String heroVideoPath; // "",
    private String introduce; // "",
    private String palmHeroHeadImg; // "https://game.gtimg.cn/images/lol/act/img/zmheropage/7.jpg",
    private String relations; // []

    // -----------------------------------------------------------------------------------------------------------------

    public Integer getChampionId() {
        if (heroId == null) return null;
        return Integer.parseInt(heroId);
    }

    public String getName() {
        return title;
    }

    public String getTitle() {
        return name;
    }

    public String getAlias() {
        return keywords;
    }

    public String getClasses() {
        return StringUtils.join(roles, ",");
    }

    public Integer getAttackScore() {
        if (attack == null) return null;
        return Integer.parseInt(attack);
    }

    public Integer getMagicScore() {
        if (magic == null) return null;
        return Integer.parseInt(magic);
    }

    public Integer getDefenceScore() {
        if (defense == null) return null;
        return Integer.parseInt(defense);
    }

    public Integer getDifficultyScore() {
        if (difficulty == null) return null;
        return Integer.parseInt(difficulty);
    }

    public Integer getGoldPrice() {
        if (goldPrice == null) return null;
        return Integer.parseInt(goldPrice);
    }

    public Integer getCouponPrice() {
        if (couponPrice == null) return null;
        return Integer.parseInt(couponPrice);
    }

    public Integer getDamageType() {
        if (damageType == null) return null;
        return DamageType.getIdByKey(damageType);
    }

    public Integer getDamageStyle() {
        if (style == null) return null;
        return Integer.parseInt(style);
    }

    public Integer getDifficultyLevel() {
        if (difficultyL == null) return null;
        return Integer.parseInt(difficultyL);
    }

    public Integer getDamageLevel() {
        if (damage == null) return null;
        return Integer.parseInt(damage);
    }

    public Integer getDurabilityLevel() {
        if (durability == null) return null;
        return Integer.parseInt(durability);
    }

    public Integer getCrowdControlLevel() {
        if (crowdControl == null) return null;
        return Integer.parseInt(crowdControl);
    }

    public Integer getMobilityLevel() {
        if (mobility == null) return null;
        return Integer.parseInt(mobility);
    }

    public Integer getUtilityLevel() {
        if (utility == null) return null;
        return Integer.parseInt(utility);
    }

}
