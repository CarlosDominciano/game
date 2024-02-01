package app.game.repositories.itens;

import app.game.models.itens.WeaponModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface WeaponRepository extends JpaRepository<WeaponModel, Integer> {

    boolean existsByName(String name);

    @Modifying
    @Transactional
    @Query("update WeaponModel w set w.level = ?2 where w.id = ?1")
    void updateLevel(int idWeapon, int level);

    @Query("SELECT id FROM WeaponModel ORDER BY id DESC")
    List<Integer> findLastWeaponId();
}
