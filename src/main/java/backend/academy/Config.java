package backend.academy;

public final class Config {
    private Config() {

    }

    public static final int TOTAL_ATTEMPTS = 6;

    //Для выбора категорий: Природа, страны, животные и тд
    public static final int RANDOM_CATEGORY_MIN = 1;
    public static final int RANDOM_CATEGORY_MAX = 4;

    //Константы для выбора сложности уровня: 1-3
    public static final int RANDOM_LEVEL_MIN = 1;
    public static final int RANDOM_LEVEL_MAX = 3;

    //Путь файла
    public static String filePathOfWord = "src/main/resources/WordDictionary.txt";
}
