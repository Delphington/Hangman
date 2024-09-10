package backend.academy;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Map;
import java.util.Scanner;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {

    //Уровень 1: слова из букв 1-4
    //Уровень 2: слова из букв 5-8
    //Уровень 3: слова из букв 9-14

    Scanner scan = new Scanner(System.in, StandardCharsets.UTF_8);
   // Random random = new Random();
    SecureRandom random = new SecureRandom();
    Map<String, String> mapWordAndHint;
    int indexWord;
    int category;
    int level;
//    private final char SPACE = ' ';
//    private final char UNDERLINE = ' ';

    public static void main(String[] args) {
        DrawingGallow drawingGallow = new DrawingGallow();
        while (true) {
            category = Chosen.chooseCategory(scan, System.out, random);
            level = Chosen.chooseLevel(scan, System.out, random);

            try {
                mapWordAndHint = SrvInitialization.getInfo(category, level);
            } catch (Exception e) {
                return;
            }

            //Индекс для выбора слова из категории
            indexWord = random.nextInt(mapWordAndHint.size()) + 0;

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
