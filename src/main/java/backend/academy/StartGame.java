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
    static int indexWord;
    static int category;
    static int level;

    static DrawingGallow drawingGallow = new DrawingGallow();

    public static void startGame() {
        while (true) {
            category = Chosen.chooseCategory(scan, System.out, random);
            level = Chosen.chooseLevel(scan, System.out, random);

            mapWordAndHint = SrvInitialization.getInfo(category, level, System.out);

            //Индекс для выбора слова из категории
            indexWord = random.nextInt(mapWordAndHint.size());

            //Выбранное слово
            String ourWord = (String) mapWordAndHint.keySet().toArray()[indexWord];

            //Строка, которая будет менятся и которую будем угадывать
            StringBuilder foreignStr = new StringBuilder();
            for (int i = 0; i < ourWord.length(); i++) {
                foreignStr.append("_");
                foreignStr.append(" ");
            }

            //Копия нашей, строки. Нужно чтобы было удобно сравнивать с foreignStr
            StringBuilder cloneForeignStr = new StringBuilder();
            for (int i = 0; i < ourWord.length(); i++) {
                cloneForeignStr.append(ourWord.charAt(i));
                cloneForeignStr.append(" ");
            }
            LogicGame.play(drawingGallow, ourWord, foreignStr, cloneForeignStr, System.out, scan);
            drawingGallow.setCountError(0);

            if (!Chosen.chooseAction(System.out, scan)) {
                break;
            }
        }
        scan.close();

    }
}
