package backend.academy;

public enum WordCategory {
    SPORT("Спорт"),
    ANIMAL("Животные"),
    NATURE("Природа"),
    COUNTRY("Страны");
    private final String description;

    WordCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
