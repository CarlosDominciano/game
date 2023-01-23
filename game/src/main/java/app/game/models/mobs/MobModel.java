package app.game.models.mobs;

import app.game.enums.coditionsEnums.ConditionStatusEnum;
import app.game.models.itens.WeaponModel;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class MobModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Min(1)
    @Positive
    private Long xp;

    @Column(nullable = false)
    @Min(1)
    @Positive
    private int level;

    @Column(nullable = false)
    @Positive
    private int hitPoints;

    @Column(nullable = false)
    @Positive
    private int strength;

    @Column(nullable = false)
    @Positive
    private int defense;

    @ManyToOne
    private WeaponModel equipedWeapon;

    @Column
    private int condition;

    public MobModel() {
    }

    public MobModel( String name, Long xp, int level,
                    int hitPoints, int strength, int defense,
                    WeaponModel equipedWeapon, ConditionStatusEnum condition) {
        this.name = name;
        this.xp = xp;
        this.level = level;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.defense = defense;
        this.equipedWeapon = equipedWeapon;
        setCondition(condition);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public WeaponModel getEquipedWeapon() {
        return equipedWeapon;
    }

    public void setEquipedWeapon(WeaponModel equipedWeapon) {
        this.equipedWeapon = equipedWeapon;
    }

    public ConditionStatusEnum getCondition() {
        return ConditionStatusEnum.valueOf(condition);
    }

    public void setCondition(ConditionStatusEnum condition) {
        if (condition != null)
            this.condition = condition.getCode();
    }

    @Override
    public String toString() {
        return "MobModel{" +
                ", name='" + name + '\'' +
                ", xp=" + xp +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", defense=" + defense +
                ", equipedWeapon=" + equipedWeapon +
                ", condition=" + condition +
                '}';
    }
}
