package app.game.exceptions.itens;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Weapon don't have the necessary XP to upgrade")
public class WeaponDidNotLevelUpException extends RuntimeException{
}
