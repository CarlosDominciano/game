package app.game.repositories.inventories;

import app.game.models.inventories.InventoryModel;
import app.game.models.itens.WeaponModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryModel, Integer> {



}
