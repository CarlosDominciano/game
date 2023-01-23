package app.game.dtos.requests.itens;

import app.game.enums.weaponsEnums.WeaponElementEnum;
import app.game.enums.weaponsEnums.WeaponRangeTypeEnum;

public class WeaponRequest {

    private String name;
    private String description;
    private Long xp;
    private int rangeType;
    private int element;
    private int strength;

    public WeaponRequest() {

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getXp() {
        return xp;
    }

    public WeaponRangeTypeEnum getRangeType() {
        return WeaponRangeTypeEnum.valueOf(rangeType);
    }

    public WeaponElementEnum getElement() {
        return WeaponElementEnum.valueOf(element);
    }

    public int getStrength() {
        return strength;
    }

//    public int getStrength() {
//        return 19;
//    }
}
