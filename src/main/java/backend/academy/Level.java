package backend.academy;

//        printStream.println("Выберите уровень сложности: \n"
//    + "[" + LEVEL_1 + "] Легкий \n"
//    + "[" + LEVEL_2 + "] Средний \n"
//    + "[" + LEVEL_3 + "] Сложный"
//);

public enum Level {
    LEVEL_1("Легкий"),
    LEVEL_2("Средний"),
    LEVEL_3("Сложный");

    private String value;
    private final static Level[] ARR = {LEVEL_1, LEVEL_2, LEVEL_3};

    Level(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
