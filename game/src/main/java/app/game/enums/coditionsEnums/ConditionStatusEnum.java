package app.game.enums.coditionsEnums;

public enum ConditionStatusEnum {

    NONE(1);

    private int code;

    ConditionStatusEnum(int value){
        this.code = value;
    }

    public int getCode() {
        return code;
    }

    public static ConditionStatusEnum valueOf(int code) {
        for (ConditionStatusEnum value : ConditionStatusEnum.values()) {
            if (code == value.getCode())
                return value;
        }
        throw new IllegalArgumentException("Invalid condition status.");
    }

}
