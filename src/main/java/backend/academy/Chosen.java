package backend.academy;

import java.io.PrintStream;
import java.security.SecureRandom;
import java.util.Scanner;

public final class Chosen {
    private Chosen() {
    }

    private static int category = 0;
    private static int level = 0;

    static String line = null;

    public static int chooseCategory(Scanner scan, PrintStream printStream, SecureRandom random) {

        printStream.println("Выберите номер категории слов: ");
        for (WordCategory wordCategory : WordCategory.values()) {
            printStream.println("[" + (wordCategory.ordinal() + 1) + "] " + wordCategory.getDescription());
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
                    printStream.println(Config.WARNING_INCORRECT_NUMBER);
                } catch (Exception e) {
                    printStream.println(Config.WARNING_INCORRECT_NUMBER);

                }

            }

        }
    }

    public static int chooseLevel(Scanner scan, PrintStream printStream, SecureRandom random) {

        printStream.println("Выберите уровень сложности: ");
        for (Level v : Level.values()) {
            printStream.println("[" + (v.ordinal() + 1) + "] " + v.getValue());
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
                    printStream.println(Config.WARNING_INCORRECT_NUMBER);

                } catch (Exception e) {
                    printStream.println(Config.WARNING_INCORRECT_NUMBER);

                }
            }
        }
    }

    public static boolean chooseAction(PrintStream printStream, Scanner scan) {
        printStream.println("[С]ontinue OR [E]xit");
        while (true) {
            line = scan.nextLine().trim();
            if (line.isEmpty()) {
                printStream.println(Config.MESSAGE_INPUT_LETTER);
            } else {
                if (CheckData.checkChar(line)
                    && line.equalsIgnoreCase("C")
                    || line.equalsIgnoreCase("С")) {
                    return true;
                } else if (CheckData.checkChar(line)
                    && line.equalsIgnoreCase("E")
                    || line.equalsIgnoreCase("Е")) {
                    printStream.println("Игра завершена!");
                    return false;
                } else {
                    printStream.println(Config.MESSAGE_INPUT_LETTER);
                }
            }
        }
    }
}
