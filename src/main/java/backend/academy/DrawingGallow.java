package backend.academy;

import java.io.PrintStream;
import lombok.Getter;

@Getter
@SuppressWarnings("all")
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

    private static final String[] HANGMAN_STAGES = {
        "_________________\n"
            + "|  || //        | \n"
            + "   ||//         0 \n"
            + "   ||\n"
            + "   ||\n"
            + "   ||\n"
            + "   ||\n"
            + "   ||\n"
            + "=========|__ \n"
            + "            |__\n",

        "_________________\n"
            + "|  || //        | \n"
            + "   ||//         0 \n"
            + "   ||          / \n"
            + "   ||\n"
            + "   ||\n"
            + "   ||\n"
            + "   ||\n"
            + "=========|__  \n"
            + "            |__ \n",

        "_________________\n"
            + "|  || //        | \n"
            + "   ||//         0 \n"
            + "   ||          /| \n"
            + "   ||\n"
            + "   ||\n"
            + "   ||\n"
            + "   ||\n"
            + "=========|__ \n"
            + "            |__\n",

        "_________________\n"
            + "|  || //        | \n"
            + "   ||//         0 \n"
            + "   ||          /| \\\n"
            + "   ||\n"
            + "   ||\n"
            + "   ||\n"
            + "   ||\n"
            + "=========|__ \n"
            + "            |__\n",

        "_________________\n"
            + "|  || //        | \n"
            + "   ||//         0 \n"
            + "   ||          /|\\ \n"
            + "   ||          / \n"
            + "   ||\n"
            + "   ||\n"
            + "   ||\n"
            + "=========|__ \n"
            + "            |__\n",

        "_________________\n"
            + "|  || //        | \n"
            + "   ||//         0 \n"
            + "   ||          /|\\ \n"
            + "   ||          / \\ \n"
            + "   ||\n"
            + "   ||\n"
            + "   ||\n"
            + "=========|__ \n"
            + "            |__\n"

    };

    public void printGallows(PrintStream printStream) {
        printStream.println(HANGMAN_STAGES[countError - 1]);
    }
}
