package app.game.enums.weaponsEnums;


public enum WeaponRangeTypeEnum {

    MELEE_SHORT(1),
    MELEE_MEDIUM(2),
    MELEE_LONG(3),
    RANGED_SHORT(4),
    RANGED_MEDIUM(5),
    RANGED_LONG(6);

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
