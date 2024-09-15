package backend.academy;

public enum Gallow {
    STEP_1("           |"),
    STEP_2("|           0"),
    STEP_3("|          /"),
    STEP_4(" \\"),
    STEP_5("|          /|\\"),
    STEP_HELP("|");

    private final String value;

    Gallow(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
