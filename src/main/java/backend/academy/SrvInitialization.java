package backend.academy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class SrvInitialization {

    private SrvInitialization() {
    }

    private static final Logger LOGGER = Logger.getLogger(SrvInitialization.class.getName());

    public static Map<String, String> wordAndHint;

    public static Map<String, String> getInfo(int category, int level) {

        String filePath = Config.FILE_PATH_OF_WORD;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {

                if (line.contains("[" + category + ":" + level + "]")) {
                    String str;
                    wordAndHint = new HashMap<>();
                    while ((str = br.readLine()) != null && !str.contains("[")) {
                        String[] temp = str.trim().split(":");
                        wordAndHint.put(temp[0], temp[1]);
                    }
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return wordAndHint;

    }
}
