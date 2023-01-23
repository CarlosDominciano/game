package app.game.controller.itens;

import app.game.controllers.itens.WeaponController;
import app.game.models.itens.WeaponModel;
import app.game.repositories.itens.WeaponRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class WeaponControllerTest {

    @Autowired
    WeaponController weaponController;

    @MockBean
    WeaponRepository weaponRepository;

    @Test
    @DisplayName("Return empty list and 204 status")
    void returnEmptyListWeapons() {
        Mockito.when(weaponRepository.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity<List<WeaponModel>> weaponsList = weaponController.findAllWeapons();
        assertEquals(204, weaponsList.getStatusCodeValue());
        assertNull(weaponsList.getBody());
    }

    @Test
    @DisplayName("Return list weapons and 200 status")
    void returnListWeapons() {
        Mockito.when(weaponRepository.findAll()).thenReturn(List.of(
                new WeaponModel(),
                new WeaponModel()
        ));
        ResponseEntity<List<WeaponModel>> weaponsList = weaponController.findAllWeapons();
        assertEquals(200, weaponsList.getStatusCodeValue());
    }
}
