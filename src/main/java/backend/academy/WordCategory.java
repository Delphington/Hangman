package backend.academy;

import lombok.Getter;

public enum WordCategory {
    SPORT("Спорт"),
    ANIMAL("Животные"),
    NATURE("Природа"),
    COUNTRY("Страны");

    @Getter
    private final String description;

    WordCategory(String description) {
        this.description = description;
    }

}
