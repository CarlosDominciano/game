package app.game.exceptions.mobs;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Character don't have the necessary XP to upgrade")
public class CharacterDidNotLevelUpException extends RuntimeException{
}


