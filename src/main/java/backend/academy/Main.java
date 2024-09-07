package backend.academy;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {

    //Уровень 1: слова из букв 1-4
    //Уровень 2: слова из букв 5-8
    //Уровень 3: слова из букв 9-14


    Scanner scan = new Scanner(System.in);
    Random random = new Random();
    ArrayList<String> arr;


    public static void main(String[] args) {
        DrawingGallow drawingGallow = new DrawingGallow();
        drawingGallow.printGallows(System.out);

        int category = Chosen.chooseCategory(scan, System.out, random);
        int level = Chosen.chooseLevel(scan, System.out, random);

        arr = SrvInitialization.getInfo(category,level);
        //System.out.println(arr);



        //Индекс для выбора слова из категории
        int indexWord = random.nextInt(arr.size()) + 0;

        //Выбранное слово
        String ourWord = new String(arr.get(indexWord));

        //Строка, которая будет менятся и которую будем угадывать
        StringBuilder foreignStr = new StringBuilder();
        for (int i = 0; i < ourWord.length(); i++) {
            foreignStr.append("_");
            foreignStr.append(" ");
        }

        //Копия нашей, строки. Нужно чтобы было удобно сравнивать с ForeignStr
        StringBuilder cloneForeignStr = new StringBuilder();
        for (int i = 0; i < ourWord.length(); i++) {
            cloneForeignStr.append(ourWord.charAt(i));
            cloneForeignStr.append(" ");
        }
        LogicGame.play(drawingGallow, ourWord, foreignStr, cloneForeignStr, System.out, scan);

        scan.close();
    }
}
