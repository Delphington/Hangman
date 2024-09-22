package backend.academy;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum Level implements StringConst {
    EASY(LEVEL_EASY),
    NORMAL(LEVEL_NORMAL),
    HARD(LEVEL_HARD);

    private final String value;
}
