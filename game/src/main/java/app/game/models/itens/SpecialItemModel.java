package app.game.models.itens;

import app.game.enums.itensEnums.UsageKeyEnum;
import app.game.enums.weaponsEnums.WeaponElementEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_special_itens")
public class SpecialItemModel extends ItemModel{

    @Column(nullable = false)
    private int usageKey;

    public SpecialItemModel() {
    }

    public SpecialItemModel(String name, String description, UsageKeyEnum usageKey) {
        super(name, description);
        setUsageKey(usageKey);
    }

    public UsageKeyEnum getUsageKey() {
        return UsageKeyEnum.valueOf(usageKey);
    }

    public void setUsageKey(UsageKeyEnum usageKey) {
        if (usageKey != null)
            this.usageKey = usageKey.getCode();
    }

}
