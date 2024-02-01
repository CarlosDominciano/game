package app.game.controllers.mobs;

import app.game.controllers.inventories.InventoryController;
import app.game.controllers.itens.WeaponController;
import app.game.dtos.requests.mobs.CharacterRequest;
import app.game.exceptions.itens.WeaponDidNotLevelUpException;
import app.game.exceptions.itens.WeaponNotFoundException;
import app.game.models.inventories.InventoryModel;
import app.game.models.itens.WeaponModel;
import app.game.models.mobs.CharacterModel;
import app.game.services.itens.WeaponService;
import app.game.services.mobs.CharacterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mobs/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;
    @Autowired
    private WeaponService weaponService;
    @Autowired
    private InventoryController inventoryController;

    @PostMapping
    public ResponseEntity<CharacterModel> createCharacter(@RequestBody @Valid CharacterRequest characterRequest) {
        CharacterModel characterModel = characterService.createCharacter(characterRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(characterModel);
    }
    @GetMapping
    public ResponseEntity<List<CharacterModel>> findAllCharacters() {
        List<CharacterModel> listCharacters = characterService.findAllCharacters();
        if (listCharacters.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.status(200).body(listCharacters);
    }

    @GetMapping("/{idCharacter}")
    public ResponseEntity<CharacterModel> findCharacterById(@PathVariable int idCharacter) {
        CharacterModel characterModel = characterService.findCharacterById(idCharacter);
        return ResponseEntity.status(200).body(characterModel);
    }

    @PatchMapping("/level-up/{idCharacter}")
    public ResponseEntity<Void> upgradeCharacterLevel(@PathVariable int idCharacter) {
        characterService.upgradeCharacterLevel(idCharacter);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{idCharacter}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable int idCharacter) {
        characterService.deleteCharacter(idCharacter);
        return ResponseEntity.noContent().build();
    }


}


