package app.game.models.itens;

import app.game.enums.weaponsEnums.WeaponElementEnum;
import app.game.enums.weaponsEnums.WeaponRangeTypeEnum;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "tb_weapons")
public class WeaponModel extends ItemModel {

    @Positive
    @Column(nullable = false)
    private int strength;

    @Positive
    @Column(nullable = false)
    private Long xp;

    @Positive
    @Column(nullable = false)
    private int level;

    @Positive
    @Column(nullable = false)
    private int rangeType;

    @Positive
    @Column
    private int element;

    public WeaponModel() {
    }

    public WeaponModel(String name, String description,
                       int strength, Long xp, WeaponRangeTypeEnum rangeType,
                       WeaponElementEnum element) {
        super(name, description);
        this.strength = strength;
        this.xp = xp;
        this.level = (int)(Math.log(getXp())/Math.log(2)) + 1;
        setRangeType(rangeType);
        setElement(element);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Long getXp() {
        return xp;
    }

    public void setXp(Long xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel() {
        this.level = (int)(Math.log(getXp())/Math.log(2)) + 1;
    }

    public WeaponRangeTypeEnum getRangeType() {
        return WeaponRangeTypeEnum.valueOf(rangeType);
    }

    public void setRangeType(WeaponRangeTypeEnum rangeType) {
        if (rangeType != null) {
            this.rangeType = rangeType.getCode();
        }
    }

    public WeaponElementEnum getElement() {
        return WeaponElementEnum.valueOf(element);
    }

    public void setElement(WeaponElementEnum element) {
        if (element != null)
            this.element = element.getCode();
    }

    @Override
    public String toString() {
        return "WeaponModel{" +
                "strength=" + strength +
                ", xp=" + xp +
                ", level=" + level +
                ", rangeType=" + rangeType +
                ", element=" + element +
                "} " + super.toString();
    }
}
