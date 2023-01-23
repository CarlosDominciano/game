package app.game.enums.weaponsEnums;

public enum WeaponElementEnum {

    ICE(1),
    FIRE(2),
    WIND(3),
    THUNDER(4),
    DARKNESS(5),
    LIGHTNESS(6);

    private int code;

    WeaponElementEnum(int value) {
        this.code = value;
    }

    public int getCode() {
        return code;
    }

    public static WeaponElementEnum valueOf(int code) {
        for (WeaponElementEnum value : WeaponElementEnum.values()) {
            if (code == value.getCode())
                return value;
        }
        throw new IllegalArgumentException("Invalid weapon element.");
    }
}