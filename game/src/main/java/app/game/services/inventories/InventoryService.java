package app.game.services.inventories;

import app.game.models.inventories.InventoryModel;
import app.game.models.mobs.CharacterModel;
import app.game.repositories.inventories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

@Service
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    // Database Methods
    @Transactional
    public InventoryModel save(InventoryModel inventoryModel) {
        return inventoryRepository.save(inventoryModel);
    }


    // Controller Methods

    public InventoryModel createInventory(int idMob) {
        InventoryModel inventoryModel = new InventoryModel();
        return inventoryRepository.save(inventoryModel);
    }
}
