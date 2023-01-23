package app.game.controllers.itens;

import app.game.dtos.requests.itens.WeaponRequest;
import app.game.exceptions.itens.WeaponDidNotLevelUpException;
import app.game.exceptions.itens.WeaponNameAlreadyExistsException;
import app.game.models.itens.WeaponModel;
import app.game.services.itens.WeaponService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/weapons")
public class WeaponController {

    @Autowired
    WeaponService weaponService;

    @PostMapping
    public ResponseEntity<WeaponModel> createWeapon(
            @RequestBody @Valid WeaponRequest weaponRequest) {
        if (weaponService.existsByName(weaponRequest.getName()))
            throw new WeaponNameAlreadyExistsException();
        WeaponModel weaponModel = new WeaponModel();
        BeanUtils.copyProperties(weaponRequest, weaponModel);
        weaponModel.setLevel();
        return ResponseEntity.status(HttpStatus.CREATED).body(weaponService.save(weaponModel));
    }

    @GetMapping
    public ResponseEntity<List<WeaponModel>> findAllWeapons() {
        List<WeaponModel> listWeapons = weaponService.findAll();
        if (listWeapons.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.status(HttpStatus.OK).body(listWeapons);
    }

    @GetMapping("/{idWeapon}")
    public ResponseEntity<WeaponModel> findWeaponById(@PathVariable int idWeapon) {
        if (!weaponService.existsById(idWeapon))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(weaponService.findById(idWeapon).get());
    }

    @PatchMapping("/level-up/{idWeapon}")
    public ResponseEntity<WeaponModel> upgradeWeaponLevel(@PathVariable int idWeapon) {
        if (!weaponService.existsById(idWeapon))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        WeaponModel newWeapon = weaponService.findById(idWeapon).get();
        if (!(newWeapon.getLevel() == ((int)(Math.log(newWeapon.getXp())/Math.log(2)) + 1)))
            throw new WeaponDidNotLevelUpException();
        newWeapon.setLevel();
        weaponService.updateLevel(newWeapon.getId(), newWeapon.getLevel());
        return ResponseEntity.status(HttpStatus.OK).body(weaponService.findById(newWeapon.getId()).get());
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
