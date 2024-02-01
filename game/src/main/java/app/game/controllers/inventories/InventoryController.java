package app.game.controllers.inventories;

import app.game.dtos.requests.itens.WeaponRequest;
import app.game.exceptions.itens.WeaponNameAlreadyExistsException;
import app.game.models.inventories.InventoryModel;
import app.game.models.itens.WeaponModel;
import app.game.services.inventories.InventoryService;
import app.game.services.itens.WeaponService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/inventories")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<InventoryModel> createInventory(
            @RequestBody int idMob) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inventoryService.createInventory(idMob));
    }

    @PutMapping
    public ResponseEntity<InventoryModel> increaseInventorySize() {
        return null;
    }
}
