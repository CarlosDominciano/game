package app.game.controllers.mobs;

import app.game.dtos.requests.mobs.CharacterRequest;
import app.game.exceptions.itens.WeaponDidNotLevelUpException;
import app.game.exceptions.itens.WeaponNotFoundException;
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
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    CharacterService characterService;
    @Autowired
    WeaponService weaponService;

    @PostMapping
    public ResponseEntity<CharacterModel> createCharacter(@RequestBody @Valid CharacterRequest characterRequest) {
        if (!weaponService.existsById(characterRequest.getIdEquipedWeapon())) {
            throw new WeaponNotFoundException();
        }
        CharacterModel characterModel = new CharacterModel();
        BeanUtils.copyProperties(characterRequest, characterModel);
        characterModel.setEquipedWeapon(weaponService.findById(characterRequest.getIdEquipedWeapon()).get());
        characterModel.setLevel();
        return ResponseEntity.status(HttpStatus.CREATED).body(characterService.save(characterModel));
    }

    @GetMapping
    public ResponseEntity<List<CharacterModel>> findAllCharacters() {
        List<CharacterModel> listCharacters = characterService.findAll();
        if (listCharacters.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.status(200).body(listCharacters);
    }

    @GetMapping("/{idCharacter}")
    public ResponseEntity<CharacterModel> findCharacterById(int idCharacter) {
        if (!characterService.existsById(idCharacter))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(200).body(characterService.findById(idCharacter).get());
    }

    @PatchMapping("/level-up/{idWeapon}")
    public ResponseEntity<CharacterModel> upgradeWeaponLevel(@PathVariable int idCharacter) {
        if (!characterService.existsById(idCharacter))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        CharacterModel newCharacter = characterService.findById(idCharacter).get();
        if (!(newCharacter.getLevel() == ((int)(Math.log(newCharacter.getXp())/Math.log(2)) + 1)))
            throw new WeaponDidNotLevelUpException();
        newCharacter.setLevel();
        characterService.updateLevel(idCharacter, newCharacter.getLevel());
        return ResponseEntity.status(HttpStatus.OK).body(characterService.findById(newCharacter.getId()).get());
    }

    @DeleteMapping("/{idWeapon}")
    public ResponseEntity<String> deleteWeapon(@PathVariable int idWeapon) {
        if (!weaponService.existsById(idWeapon))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        WeaponModel deletedWeapon = weaponService.findById(idWeapon).get();
        weaponService.delete(deletedWeapon);
        String responseBody = String.format("This weapon: %s, was deleted", deletedWeapon.getName());
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }


}
