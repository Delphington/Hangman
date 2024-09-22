package backend.academy;

import java.io.PrintStream;

@SuppressWarnings("MultipleStringLiterals")
public final class DrawingGallow {

    private DrawingGallow() {
    }

    private static final String STEP_CEILING = "__________________\n";

    private static final String HANGMAN_STEP = "|  || //       |  \n";
    private static final String HANGMAN_HEAD = "   ||//        0 \n";
    private static final String HANGMAN_WALL = "   ||\n";

    private static final String HANGMAN_LEFT_ARM_LEG = "   ||         /";
    private static final String HANGMAN_BODY = "|";

    private static final String HANGMAN_RIGHT_ARM_LEG = "\\\n";
    private static final String HANGMAN_BASE = "=========|__ \n" + "            |__\n";

    /**
     * Массив, представляющий различные стадии игры и ошибок.
     */
    private static final String[] HANGMAN_STAGES = {
        HANGMAN_STEP
            + HANGMAN_HEAD
            + HANGMAN_WALL
            + HANGMAN_WALL
            + HANGMAN_WALL
            + HANGMAN_WALL
            + HANGMAN_WALL,

        HANGMAN_STEP
            + HANGMAN_HEAD
            + HANGMAN_LEFT_ARM_LEG + "\n"
            + HANGMAN_WALL
            + HANGMAN_WALL
            + HANGMAN_WALL
            + HANGMAN_WALL,

        HANGMAN_STEP
            + HANGMAN_HEAD
            + HANGMAN_LEFT_ARM_LEG
            + HANGMAN_BODY + "\n"
            + HANGMAN_WALL
            + HANGMAN_WALL
            + HANGMAN_WALL
            + HANGMAN_WALL,

        HANGMAN_STEP
            + HANGMAN_HEAD
            + HANGMAN_LEFT_ARM_LEG
            + HANGMAN_BODY
            + HANGMAN_RIGHT_ARM_LEG
            + HANGMAN_WALL
            + HANGMAN_WALL
            + HANGMAN_WALL
            + HANGMAN_WALL,

        HANGMAN_STEP
            + HANGMAN_HEAD
            + HANGMAN_LEFT_ARM_LEG
            + HANGMAN_BODY
            + HANGMAN_RIGHT_ARM_LEG
            + HANGMAN_LEFT_ARM_LEG + "\n"
            + HANGMAN_WALL
            + HANGMAN_WALL
            + HANGMAN_WALL,

        HANGMAN_STEP
            + HANGMAN_HEAD
            + HANGMAN_LEFT_ARM_LEG
            + HANGMAN_BODY
            + HANGMAN_RIGHT_ARM_LEG
            + HANGMAN_LEFT_ARM_LEG + " "
            + HANGMAN_RIGHT_ARM_LEG
            + HANGMAN_WALL
            + HANGMAN_WALL
            + HANGMAN_WALL
    };

    /**
     * Метод для печати виселицы на основе количества ошибок.
     *
     * @param printStream поток, в который будет произведен вывод виселицы.
     * @param countError количество ошибок, определяющее состояние игыр.
     */
    public static void printGallows(PrintStream printStream, int countError) {
        printStream.print(STEP_CEILING); //Верхняя часть висилицы
        printStream.print(HANGMAN_STAGES[countError - 1]);
        printStream.println(HANGMAN_BASE); // Нижняя
    }
}
