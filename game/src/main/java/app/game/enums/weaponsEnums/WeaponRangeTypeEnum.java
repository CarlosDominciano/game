package app.game.enums.weaponsEnums;


public enum WeaponRangeTypeEnum {

    MELEE(1),
    RANGED(2);

    private int code;

    WeaponRangeTypeEnum(int value) {
        this.code = value;
    }

    public int getCode() {
        return code;
    }

    public static WeaponRangeTypeEnum valueOf(int code) {
        for (WeaponRangeTypeEnum value : WeaponRangeTypeEnum.values()) {
            if (code == value.getCode())
                return value;
        }
        throw new IllegalArgumentException("Invalid weapon type.");
    }
}
