package backend.academy.game;

import backend.academy.data.CheckData;
import backend.academy.data.Level;
import backend.academy.data.WordCategory;
import backend.academy.info.Config;
import backend.academy.info.StringConst;
import java.io.PrintStream;
import java.security.SecureRandom;
import java.util.Scanner;

public final class Chosen implements StringConst {
    private Chosen() {
    }

    private static int category = 0;
    private static int level = 0;

    static String line = null;

    private static String continue1 = "С"; //Кириллица
    private static String continue2 = "C"; //Латиница

    private static String exit1 = "Е"; //Кириллица
    private static String exit2 = "E"; //латиница

    public static int chooseCategory(Scanner scan, PrintStream printStream, SecureRandom random) {

        printStream.println(MESSAGE_CHOOSE_CATEGORY);
        for (WordCategory wordCategory : WordCategory.values()) {
            printStream.println(
                OPEN_BRACKET + (wordCategory.ordinal() + 1) + CLOSE_BRACKET + SPACE + wordCategory.getDescription());
        }

        while (true) {
            line = scan.nextLine();

            if (line.isEmpty()) {
                return random.nextInt(Config.RANDOM_CATEGORY_MAX) + Config.RANDOM_CATEGORY_MIN;
            } else {
                try {
                    line = line.trim();
                    category = Integer.parseInt(line);
                    if (category >= Config.RANDOM_CATEGORY_MIN && category <= Config.RANDOM_CATEGORY_MAX) {
                        return category;
                    }
                    printStream.println(WARNING_INCORRECT_NUMBER);
                } catch (Exception e) {
                    printStream.println(WARNING_INCORRECT_NUMBER);

                }
            }
        }
    }

    public static int chooseLevel(Scanner scan, PrintStream printStream, SecureRandom random) {

        printStream.println(MESSAGE_CHOOSE_LEVEL);
        for (Level v : Level.values()) {
            printStream.println(OPEN_BRACKET + (v.ordinal() + 1) + CLOSE_BRACKET + SPACE + v.getValue());
        }

        while (true) {
            line = scan.nextLine();

            if (line.isEmpty()) {
                return random.nextInt(Config.RANDOM_LEVEL_MAX) + Config.RANDOM_LEVEL_MIN;
            } else {
                try {
                    line = line.trim();
                    level = Integer.parseInt(line);
                    if (level >= Config.RANDOM_LEVEL_MIN && level <= Config.RANDOM_LEVEL_MAX) {
                        return level;
                    }
                    printStream.println(WARNING_INCORRECT_NUMBER);

                } catch (Exception e) {
                    printStream.println(WARNING_INCORRECT_NUMBER);

                }
            }
        }
    }

    public static boolean chooseAction(PrintStream printStream, Scanner scan) {
        printStream.println(MESSAGE_CONTINUE_EXIT);
        while (true) {
            line = scan.nextLine().trim();
            if (line.isEmpty()) {
                printStream.println(MESSAGE_INPUT_LETTER);
            } else {
                if (CheckData.checkChar(line)
                    && line.equalsIgnoreCase(continue1)
                    || line.equalsIgnoreCase(continue2)) {
                    return true;
                } else if (CheckData.checkChar(line)
                    && line.equalsIgnoreCase(exit1)
                    || line.equalsIgnoreCase(exit2)) {
                    printStream.println(MESSAGE_GAVE_OVER);
                    return false;
                } else {
                    printStream.println(MESSAGE_INPUT_LETTER);
                }
            }
        }
    }
}
