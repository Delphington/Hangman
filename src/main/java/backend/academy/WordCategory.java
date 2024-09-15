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

    public static void printCategories() {
        System.out.println("Выберите номер категории слов: ");
        for (WordCategory category : WordCategory.values()) {
            System.out.println("[" + (category.ordinal() + 1) + "] " + category.getDescription());
        }
    }
}
