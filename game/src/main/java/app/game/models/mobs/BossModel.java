package app.game.models.mobs;

import app.game.enums.coditionsEnums.ConditionStatusEnum;
import app.game.models.itens.ItemModel;
import app.game.models.itens.WeaponModel;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "tb_bosses")
public class BossModel extends MobModel {

    @Column(nullable = false)
    @Positive
    private int goldReward;

    @Column(nullable = false)
    @Min(1)
    @Positive
    private int xpReward;

    @ManyToOne
    private ItemModel itemReward;

    public BossModel() {
    }

//    public BossModel(int id, String name, Long xp, int level,
//                     int hitPoints, int strength, int defense,
//                     WeaponModel equipedWeapon, ConditionStatusEnum condition,
//                     int goldReward, int xpReward, ItemModel itemReward) {
//        super(id, name, xp, level, hitPoints, strength, defense, equipedWeapon, condition);
//        this.goldReward = goldReward;
//        this.xpReward = xpReward;
//        this.itemReward = itemReward;
//    }

    public int getGoldReward() {
        return goldReward;
    }

    public void setGoldReward(int goldReward) {
        this.goldReward = goldReward;
    }

    public int getXpReward() {
        return xpReward;
    }

    public void setXpReward(int xpReward) {
        this.xpReward = xpReward;
    }

    public ItemModel getItemReward() {
        return itemReward;
    }

    public void setItemReward(ItemModel itemReward) {
        this.itemReward = itemReward;
    }
}
