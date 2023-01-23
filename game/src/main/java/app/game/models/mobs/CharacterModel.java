package app.game.models.mobs;

import app.game.enums.coditionsEnums.ConditionStatusEnum;
import app.game.models.inventories.SpecialItemInventoryModel;
import app.game.models.inventories.InventoryModel;
import app.game.models.itens.WeaponModel;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "tb_characters")
public class CharacterModel extends MobModel{

    @Column(nullable = false)
    @PositiveOrZero
    private int gold;

    @OneToOne(optional = true)
    private InventoryModel inventory;

    @OneToOne(optional = true)
    private SpecialItemInventoryModel collectableInventory;

    public CharacterModel() {
    }

//    public CharacterModel(int id, String name, Long xp, int level,
//                          int hitPoints, int strength, int defense,
//                          WeaponModel equipedWeapon, ConditionStatusEnum condition,
//                          int gold, InventoryModel inventory,
//                          SpecialItemInventoryModel collectableInventory) {
//        super(name, xp, level, hitPoints, strength, defense, equipedWeapon, condition);
//        this.gold = gold;
//        this.inventory = inventory;
//        this.collectableInventory = collectableInventory;
//    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public InventoryModel getInventory() {
        return inventory;
    }

    public void setInventory(InventoryModel inventory) {
        this.inventory = inventory;
    }

    public SpecialItemInventoryModel getCollectableInventory() {
        return collectableInventory;
    }

    public void setCollectableInventory(SpecialItemInventoryModel collectableInventory) {
        this.collectableInventory = collectableInventory;
    }
}
