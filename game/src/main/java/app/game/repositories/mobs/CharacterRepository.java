package app.game.repositories.mobs;

import app.game.models.mobs.CharacterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterModel, Integer> {

    @Modifying
    @Transactional
    @Query("update CharacterModel c set c.level = ?2 where c.id = ?1")
    void updateLevel(int idCharacter, int level);

    @Query("SELECT id FROM CharacterModel ORDER BY id DESC")
    List<Integer> findLastCharacterId();


}
