package backend.academy;

//        printStream.println("Выберите уровень сложности: \n"
//    + "[" + LEVEL_1 + "] Легкий \n"
//    + "[" + LEVEL_2 + "] Средний \n"
//    + "[" + LEVEL_3 + "] Сложный"
//);

public enum Level {
    EASY("Легкий"),
    NORMAL("Средний"),
    HARD("Сложный");

    private String value;
    private final static Level[] ARR = {EASY, NORMAL, HARD};

    Level(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
