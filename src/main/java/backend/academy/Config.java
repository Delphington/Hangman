package backend.academy;

public final class Config {
    private Config() {

    }

    public static final int ERROR_CASE_1 = 1;
    public static final int ERROR_CASE_2 = 2;
    public static final int ERROR_CASE_3 = 3;
    public static final int ERROR_CASE_4 = 4;
    public static final int ERROR_CASE_5 = 5;
    public static final int ERROR_CASE_6 = 6;

    public static final int TOTAL_ATTEMPTS = 6;

    //Для выбора категорий: Природа, страны, животные и тд
    public static final int RANDOM_CATEGORY_MIN = 1;
    public static final int RANDOM_CATEGORY_MAX = 4;

    //Константы для выбора сложности уровня: 1-3
    public static final int RANDOM_LEVEL_MIN = 1;
    public static final int RANDOM_LEVEL_MAX = 3;

    //Варнинги-строки
    public static final String WARNING_MESSAGE = "Ошибка! Введите число: ";
    public static final String MESSAGE = "Введите букву: ";

    public static final String REMAINING_ATTEMPTS = "Количество ваших попыток: ";

    //Пути файлов
    public static final String FILE_PATH_OF_WORD = "src/main/resources/WordDictionary.txt";

}
