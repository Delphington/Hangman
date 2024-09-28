package backend.academy.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Level {

    EASY("Легкий"),
    NORMAL("Средний"),
    HARD("Сложный");

    private final String value;
}
