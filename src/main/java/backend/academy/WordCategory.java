package backend.academy;

import lombok.Getter;

public enum WordCategory implements StringConst {
    SPORT(CATEGORY_SPORT),
    ANIMAL(CATEGORY_ANIMAL),
    NATURE(CATEGORY_NATURE),
    COUNTRY(CATEGORY_COUNTRY);

    @Getter
    private final String description;

    WordCategory(String description) {
        this.description = description;
    }
}
