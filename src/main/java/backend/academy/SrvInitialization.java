package backend.academy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SrvInitialization {

    static ArrayList<String> arr;

    public static ArrayList<String> getInfo(int category, int level) {
        String filePath = "src/main/resources/WordDictionary.txt"; // Укажите путь к вашему файлу

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {

                arr = new ArrayList<>();

                if (line.contains("["+category+":"+level+"]")) {
                    String str;
                    while ((str = br.readLine()) != null
                        && !str.contains("[")) {
                        arr.add(str);
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Обработка исключений
        }
        return arr;

    }
}
