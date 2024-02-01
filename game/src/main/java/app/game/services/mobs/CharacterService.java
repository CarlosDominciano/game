package app.game.services.mobs;

import app.game.controllers.mobs.CharacterController;
import app.game.dtos.requests.mobs.CharacterRequest;
import app.game.exceptions.itens.WeaponDidNotLevelUpException;
import app.game.exceptions.itens.WeaponNotFoundException;
import app.game.exceptions.mobs.CharacterDidNotLevelUpException;
import app.game.exceptions.mobs.CharacterNotFoundException;
import app.game.models.inventories.InventoryModel;
import app.game.models.itens.WeaponModel;
import app.game.models.mobs.CharacterModel;
import app.game.repositories.mobs.CharacterRepository;
import app.game.services.inventories.InventoryService;
import app.game.services.itens.WeaponService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private WeaponService weaponService;

    @Autowired
    private InventoryService inventoryService;

    // Database Methods
    @Transactional
    public CharacterModel save(CharacterModel characterModel) {
        return characterRepository.save(characterModel);
    }
    public List<CharacterModel> findAll() {
        return characterRepository.findAll();
    }
    public int findLastCharacterId() {
        List<Integer> lastId = characterRepository.findLastCharacterId();
        if (lastId.isEmpty()) {
            return 1;
        }
        return lastId.get(0)+1;
    }
    public boolean existsById(int id) {
        return characterRepository.existsById(id);
    }
    public Optional<CharacterModel> findById(int idCharacter) {
        return characterRepository.findById(idCharacter);
    }
    public void updateLevel(int idCharacter, int level) {
        characterRepository.updateLevel(idCharacter, level);
    }
    public void delete(CharacterModel characterModel) {
        characterRepository.delete(characterModel);
    }


    // Controller Methods
    public CharacterModel createCharacter(CharacterRequest characterRequest) {
        if (!weaponService.existsById(characterRequest.getIdEquipedWeapon())) {
            throw new WeaponNotFoundException();
        }
        CharacterModel characterModel = new CharacterModel();
        BeanUtils.copyProperties(characterRequest, characterModel);
        characterModel.setEquipedWeapon(weaponService.findById(characterRequest.getIdEquipedWeapon()).get());
        characterModel.setLevel();
        characterModel.setId(this.findLastCharacterId());
        InventoryModel inventoryModel = inventoryService.createInventory(characterModel.getId());
        characterModel.setInventory(inventoryModel);
        return characterRepository.save(characterModel);
    }

    public List<CharacterModel> findAllCharacters() {
        return this.findAll();
    }

    public CharacterModel findCharacterById(int idCharacter) {
        if (!this.existsById(idCharacter))
            throw new CharacterNotFoundException();
        return this.findById(idCharacter).get();
    }

    public void upgradeCharacterLevel(int idCharacter) {
        if (!this.existsById(idCharacter))
           throw new CharacterNotFoundException();
        CharacterModel newCharacter = this.findById(idCharacter).get();
        if ((newCharacter.getLevel() == ((int)(Math.log(newCharacter.getXp())/Math.log(2)) + 1)))
            throw new CharacterDidNotLevelUpException();
        newCharacter.setLevel();
        this.updateLevel(idCharacter, newCharacter.getLevel());
    }

    public void deleteCharacter(@PathVariable int idCharacter) {
        if (!this.existsById(idCharacter))
            throw new CharacterNotFoundException();
        this.delete(this.findById(idCharacter).get());
    }

}
