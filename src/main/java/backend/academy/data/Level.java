package backend.academy.data;

import backend.academy.info.StringConst;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Level implements StringConst {

    EASY("Легкий"),
    NORMAL("Средний"),
    HARD("Сложный");

    private final String value;
}
