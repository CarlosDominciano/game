package app.game.exceptions.itens;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Weapon not found")
public class WeaponNotFoundException extends RuntimeException{
}
