package app.game.services.itens;

import app.game.models.itens.WeaponModel;
import app.game.repositories.itens.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class WeaponService {

    @Autowired
    WeaponRepository weaponRepository;

    @Transactional
    public WeaponModel save(WeaponModel weaponModel) {
        return weaponRepository.save(weaponModel);
    }
    public List<WeaponModel> findAll() {
        return  weaponRepository.findAll();
    }
    public boolean existsById(int id) {
        return weaponRepository.existsById(id);
    }
    public boolean existsByName(String name) {
        return weaponRepository.existsByName(name);
    }
    public Optional<WeaponModel> findById(int id) {
        return weaponRepository.findById(id);
    }
    public void delete(WeaponModel weaponModel) {
        weaponRepository.delete(weaponModel);
    }
    public void updateLevel(int idWeapon, int level) {
        weaponRepository.updateLevel(idWeapon, level);
    }

}
