package backend.academy;

import java.io.PrintStream;


@SuppressWarnings("all")
public final class DrawingGallow {

    private DrawingGallow() {
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
            + "   ||          /|\\\n"
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

    public static void printGallows(PrintStream printStream, int countError) {
        printStream.println(HANGMAN_STAGES[countError - 1]);
    }
}
