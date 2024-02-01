package app.game.models.inventories;

import app.game.models.itens.ItemModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_inventories")
public class InventoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private ItemModel[] itens;

    @Column
    private int inventorySize = 10;

    public InventoryModel() {
        itens = new ItemModel[inventorySize];
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

    public void setItens(ItemModel[] itens) {
        this.itens = itens;
    }

    public int getInventorySize() {
        return inventorySize;
    }

    public void setInventorySize(int inventorySize) {
        this.inventorySize = inventorySize;
    }
}
