package app.game.models.inventories;

import app.game.models.itens.ItemModel;
import app.game.models.itens.SpecialItemModel;

import javax.persistence.*;

@Entity
@Table(name = "tb_special_item_inventories")
public class SpecialItemInventoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private SpecialItemModel[] itens;

    @Column
    private int inventorySize = 10;

    public SpecialItemInventoryModel() {
        itens = new SpecialItemModel[inventorySize];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ItemModel[] getItens() {
        return itens;
    }

    public void setItens(SpecialItemModel[] itens) {
        this.itens = itens;
    }

    public int getInventorySize() {
        return inventorySize;
    }

    public void setInventorySize(int inventorySize) {
        this.inventorySize = inventorySize;
    }
}
