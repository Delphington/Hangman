package backend.academy;

import lombok.Getter;

public enum Level {
    EASY("Легкий"),
    NORMAL("Средний"),
    HARD("Сложный");

    @Getter
    private String value;
    private final static Level[] ARR = {EASY, NORMAL, HARD};

    Level(String value) {
        this.value = value;
    }
}
