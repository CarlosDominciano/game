package app.game.services.mobs;

import app.game.models.mobs.CharacterModel;
import app.game.repositories.mobs.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    @Transactional
    public CharacterModel save(CharacterModel characterModel) {
        return characterRepository.save(characterModel);
    }
    public List<CharacterModel> findAll() {
        return characterRepository.findAll();
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
}
