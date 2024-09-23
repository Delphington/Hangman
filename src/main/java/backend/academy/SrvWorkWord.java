package backend.academy;

import backend.academy.info.Config;
import backend.academy.info.StringConst;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import lombok.Getter;

@Getter
public final class SrvWorkWord implements StringConst {

    private SrvWorkWord() {
    }

    private static Map<String, String> wordAndHint;
    @Getter
    private static String word;
    @Getter
    private static String hint;

    /**
     * Получает информацию о словах и подсказках для заданной категории и уровня.
     *
     * @param category   категория слов
     * @param level      уровень сложности слов
     * @param printStream поток для вывода сообщений об ошибках
     * @return map, содержащая слова и соответствующие им подсказки
     */

    public static void initialization(int category, int level, PrintStream printStream, Random random) {

        String filePath = Config.filePathOfWord;

        try (BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(OPEN_BRACKET + category + ":" + level + CLOSE_BRACKET)) {
                    String str;
                    wordAndHint = new HashMap<>();
                    while ((str = br.readLine()) != null && !str.contains(OPEN_BRACKET)) {
                        String[] temp = str.trim().split(":");
                        if (temp.length == 2) {
                            wordAndHint.put(temp[0], temp[1]);
                        }
                    }
                    break; // Выход из цикла после нахождения нужной категории и уровня
                }
            }
        } catch (FileNotFoundException e) {
            printStream.println(e.getMessage());
        } catch (IOException e) {
            printStream.println(e.getMessage());
        }

        // Индекс для выбора слова из категории
        int indexWord = random.nextInt(wordAndHint.size());

        // Выбранное слово и подсказка
        word = (String) wordAndHint.keySet().toArray()[indexWord];
        hint = (String) wordAndHint.values().toArray()[indexWord];
    }
}
