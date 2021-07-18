package com.liger.common.genshin.controller;

import com.liger.common.genshin.entity.GenshinCharacterEntity;
import com.liger.common.genshin.enums.Element;
import com.liger.common.genshin.enums.WeaponType;
import com.liger.common.genshin.service.GenshinCharacterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/genshin/character")
public class GenshinCharacterController {

    @Autowired
    private GenshinCharacterService characterService;

    @GetMapping(value = "/list")
    public List<GenshinCharacterEntity> list(HttpServletRequest request) {

        GenshinCharacterEntity param = new GenshinCharacterEntity();

        String rarity = StringUtils.trimToNull(request.getParameter("rarity"));
        if (rarity != null) param.setRarity(Integer.parseInt(rarity));

        String element = StringUtils.trimToNull(request.getParameter("element"));
        if (element != null) param.setElement(Element.valueOf(element.toUpperCase()));

        String weaponType = StringUtils.trimToNull(request.getParameter("weaponType"));
        if (weaponType != null) param.setWeaponType(WeaponType.valueOf(weaponType.toUpperCase()));

        String obtainable = StringUtils.trimToNull(request.getParameter("obtainable"));
        if (StringUtils.equalsIgnoreCase(obtainable, "all")) {
            param.setObtainable(null);
        } else {
            boolean unobtainable = StringUtils.equalsAnyIgnoreCase(obtainable, "false", "0");
            param.setObtainable(!unobtainable);
        }

        return characterService.list(param);

    }

}
