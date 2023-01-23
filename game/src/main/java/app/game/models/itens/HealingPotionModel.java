package app.game.models.itens;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_healing_potions")
public class HealingPotionModel extends ItemModel {

    @Column(nullable = false)
    private int amountHealing;

    public HealingPotionModel() {
    }

    public HealingPotionModel(String name, String description, int amountHealing) {
        super(name, description);
        this.amountHealing = amountHealing;
    }

    public int getAmountHealing() {
        return amountHealing;
    }

    public void setAmountHealing(int amountHealing) {
        this.amountHealing = amountHealing;
    }
}
