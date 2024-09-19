package backend.academy;

import lombok.Getter;

public enum Level implements StringConst {
    EASY(LEVEL_EASY),
    NORMAL(LEVEL_NORMAL),
    HARD(LEVEL_HARD);

    @Getter
    private String value;
    private final static Level[] ARR = {EASY, NORMAL, HARD};

    Level(String value) {
        this.value = value;
    }
}
