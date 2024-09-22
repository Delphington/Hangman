package backend.academy;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Map;
import java.util.Scanner;

public class StartGame {

    private StartGame() {

    }

    static Scanner scan = new Scanner(System.in, StandardCharsets.UTF_8);
    static SecureRandom random = new SecureRandom();
    static Map<String, String> mapWordAndHint;
    static int category;
    static int level;

    /**
     * Метод для начала игры.
     * Запускает цикл выбора категории и уровня, выбирает слово и начинает игру.
     */

    public static void startGame() {
        do {
            category = Chosen.chooseCategory(scan, System.out, random);
            level = Chosen.chooseLevel(scan, System.out, random);

            SrvWorkWord.initialization(category, level, System.out, random);

            // Выбранное слово
            String ourWord = SrvWorkWord.getWord();

            // Строка, которая будет меняться и которую будем угадывать
            StringBuilder foreignStr = new StringBuilder();

            // Копия нашей строки. Нужно, чтобы было удобно сравнивать с foreignStr
            StringBuilder cloneForeignStr = new StringBuilder();
            for (int i = 0; i < ourWord.length(); i++) {
                foreignStr.append("_").append(" "); // будет выглядеть: _ _  _ _
                cloneForeignStr.append(ourWord.charAt(i)).append(" ");  // будет выглядеть: а б в г
            }

            LogicGame.play(ourWord, foreignStr, cloneForeignStr, System.out, scan);

            LogicGame.setCountError(0);

        } while (Chosen.chooseAction(System.out, scan));
        scan.close();

    }
}
