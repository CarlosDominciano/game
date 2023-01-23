package app.game.enums.itensEnums;

import app.game.enums.weaponsEnums.WeaponElementEnum;

public enum UsageKeyEnum {

    ONE(1);

    private int code;

    UsageKeyEnum(int value) {
        this.code = value;
    }

    public int getCode() {
        return code;
    }

    public static UsageKeyEnum valueOf(int code) {
        for (UsageKeyEnum value : UsageKeyEnum.values()) {
            if (code == value.getCode())
                return value;
        }
        throw new IllegalArgumentException("Invalid usage key.");
    }
}