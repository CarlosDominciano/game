package app.game.dtos.requests.mobs;

import app.game.enums.coditionsEnums.ConditionStatusEnum;
import app.game.models.itens.WeaponModel;

public class CharacterRequest {

    private String name;
    private int idEquipedWeapon;

    public CharacterRequest() {
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return 100;
    }

    public int getIdEquipedWeapon() {
        return idEquipedWeapon;
    }

    public Long getXp() {
        return 1L;
    }

    public int getStrength() {
        return 1;
    }

    public int getDefense() {
        return 1;
    }

    public int getGold() {
        return 500;
    }

    public ConditionStatusEnum getCondition() {
        return ConditionStatusEnum.valueOf(1);
    }
}
