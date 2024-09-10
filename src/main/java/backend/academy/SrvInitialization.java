package backend.academy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class SrvInitialization {

    private SrvInitialization() {
    }

    private static Map<String, String> wordAndHint;

    public static Map<String, String> getWordAndHint() {
        return new HashMap<>(wordAndHint);
    }

    public static Map<String, String> getInfo(int category, int level) {

        String filePath = Config.FILE_PATH_OF_WORD;

        try (BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("[" + category + ":" + level + "]")) {
                    String str;
                    wordAndHint = new HashMap<>();
                    while ((str = br.readLine()) != null && !str.contains("[")) {
                        String[] temp = str.trim().split(":");
                        if (temp.length == 2) {
                            wordAndHint.put(temp[0], temp[1]);
                        }
                    }
                    break; // Выход из цикла после нахождения нужной категории и уровня
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new RuntimeException("IO error: " + e.getMessage(), e);
        }

        return wordAndHint;
    }
}
