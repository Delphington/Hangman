package backend.academy;

public class Config {
    private Config() {

    }

    public static final int TOTAL_ATTEMPTS = 6;

    //Константы для количества ошибок
    public static final int ERROR_FIRST_CASE = 1;
    public static final int ERROR_SECOND_CASE = 2;
    public static final int ERROR_THIRD_CASE = 3;
    public static final int ERROR_FOURTH_CASE = 4;
    public static final int ERROR_FIFTH_CASE = 5;
    public static final int ERROR_SIXTH_CASE = 6;

    //Для выбора категорий: Природа, страны, животные и тд
    public static final int RANDOM_CATEGORY_MIN = 1;
    public static final int RANDOM_CATEGORY_MAX = 4;
    public static final int CATEGORY_ONE = 1;
    public static final int CATEGORY_TWO = 2;
    public static final int CATEGORY_THREE = 3;
    public static final int CATEGORY_FOUR = 4;

    //Константы для выбора сложности уровня: 1-3
    public static final int RANDOM_LEVEL_MIN = 1;
    public static final int RANDOM_LEVEL_MAX = 3;
    public static final int LEVEL_ONE = 1;
    public static final int LEVEL_TWO = 2;
    public static final int LEVEL_THREE = 3;

    //Варнинги-строки
    public static final String WARNING_MESSAGE = "Ошибка! Введите число: ";
    public static final String REMAINING_ATTEMPTS = "Количество ваших попыток: ";

}
