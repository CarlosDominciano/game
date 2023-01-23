package app.game.exceptions.itens;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Weapon name is already in use")
public class WeaponNameAlreadyExistsException extends RuntimeException {
}
