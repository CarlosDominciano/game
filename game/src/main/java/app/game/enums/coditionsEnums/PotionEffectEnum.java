package app.game.enums.coditionsEnums;

public enum PotionEffectEnum {
    INCREASE_DAMAGE(1),
    INCREASE_ARMOR(2),
    FIRE_RESISTENCE(3),
    ICE_RESISTENCE(4),
    WIND_RESISTENCE(5),
    THUNDER_RESISTENCE(6),
    DARKNESS_RESISTENCE(7),
    LIGHTNESS_RESISTENCE(8);
    private int code;

    PotionEffectEnum(int value) {
        this.code = value;
    }

    public int getCode() {
        return code;
    }

    public static PotionEffectEnum valueOf(int code) {
        for (PotionEffectEnum value : PotionEffectEnum.values()) {
            if (code == value.getCode())
                return value;
        }
        throw new IllegalArgumentException("Invalid potion effect.");
    }
}
