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

    //Варнинги-строки
    public static final String WARNING_INCORRECT_NUMBER = "Ошибка! Введите цифру: ";
    public static final String MESSAGE_INPUT_LETTER = "Введите букву: ";

    public static final String REMAINING_ATTEMPTS = "Количество ваших попыток: ";

    //Путь файла
    public static String filePathOfWord = "src/main/resources/WordDictionary.txt";

}
