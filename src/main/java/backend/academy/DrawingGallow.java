package backend.academy;

import java.io.PrintStream;
import lombok.Getter;

@Getter
public final class DrawingGallow {

    @Getter private int countError = 0;

    public void setCountError(int countError) {
        this.countError = countError;
    }

    public int getCountError() {
        return countError;
    }

    public void increment() {
        countError++;
    }

    private static final String ERROR_1 =
        "_________________\n"
            + "|  || //        | \n"
            + "   ||//         0 \n"
            + "   ||\n"
            + "   ||\n"
            + "   ||\n"
            + "   ||\n"
            + "   ||\n"
            + "=========|__ \n"
            + "            |__\n";

    private static final String ERROR_2 =
        "_________________\n"
            + "|  || //        | \n"
            + "   ||//         0 \n"
            + "   ||          / \n"
            + "   ||\n"
            + "   ||\n"
            + "   ||\n"
            + "   ||\n"
            + "=========|__  \n"
            + "            |__ \n";

    private static final String ERROR_3 =
        "_________________\n"
            + "|  || //        | \n"
            + "   ||//         0 \n"
            + "   ||          /| \n"
            + "   ||\n"
            + "   ||\n"
            + "   ||\n"
            + "   ||\n"
            + "=========|__ \n"
            + "            |__\n";

    private static final String ERROR_4 =
        "_________________\n"
            + "|  || //        | \n"
            + "   ||//         0 \n"
            + "   ||          /| \\\n"
            + "   ||\n"
            + "   ||\n"
            + "   ||\n"
            + "   ||\n"
            + "=========|__ \n"
            + "            |__\n";

    private static final String ERROR_5 =
        "_________________\n"
            + "|  || //        | \n"
            + "   ||//         0 \n"
            + "   ||          /|\\ \n"
            + "   ||          / \n"
            + "   ||\n"
            + "   ||\n"
            + "   ||\n"
            + "=========|__ \n"
            + "            |__\n";

    private static final String ERROR_6 =
        "_________________\n"
            + "|  || //        | \n"
            + "   ||//         0 \n"
            + "   ||          /|\\ \n"
            + "   ||          / \\ \n"
            + "   ||\n"
            + "   ||\n"
            + "   ||\n"
            + "=========|__ \n"
            + "            |__\n";

    private static final String[] HANGMAN_STAGES = {ERROR_1, ERROR_2, ERROR_3, ERROR_4, ERROR_5, ERROR_6};

    public void printGallows(PrintStream printStream) {
        printStream.println(HANGMAN_STAGES[countError - 1]);
    }
}
