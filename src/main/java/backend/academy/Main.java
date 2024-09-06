package backend.academy;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {

    String[][] natureWords = {
        {"лес", "река", "сад", "мох", "лист", "цвет", "дождь", "корень", "плод"},
        {"гора", "озеро", "цветок", "дерево", "животное", "птица", "солнце", "облако", "ветер", "земля",
            "океан", "пейзаж", "поляна"},
        {"экосистема", "биосфера", "фотосинтез", "ландшафтный", "океанография", "пейзажистка", "организмов",
            "субтропики", "природоохранный"}
    };

    String[][] sportsWords = {
        {"лук", "игра", "прыж", "бокс", "брас", "лед", "бег", "мост", "гонка", "топ"},
        {"футбол", "боксёр", "гимнаст", "велосипед", "плавание", "теннис", "хоккей", "спортсмен", "марафон", "бегунья"},
        {"спартакиада", "чемпионат", "паралимпийдец", "тренировка", "футболистка", "бодибилдинг", "сноубординг",
            "кроссфит", "качалка"}
    };

    //----------------------------------
    //--------------------------------------------------

    String[][] animalsWords = {
        {"кот", "пес", "лев", "крыса", "утка", "рыба", "мышь", "овца", "фазан", "жук"},
        {"тигр", "лошадь", "бобер", "кенгуру", "черепаха", "пингвин", "ящерица", "сова", "утконос"},
        {"носорог", "крокодил", "слоновидный", "моржевик", "гиена", "параллельный", "млекопитающее", "африканец",
            "дикобраз", "дельфиния"}
    };

    //-------------------------------------
    String[][] countriesWords = {
        {"сша", "иран", "япония", "чад", "перу", "ливия", "кипр", "фиджи", "мали", "нигер"},
        {"норвегия", "греция", "мексика",
            "филиппины"},
        {"бразилия", "узбекистан", "турция", "словения", "канада",
            "великобритания", "нидерланды", "эквадор", "республика", "бельгия", "австралия", "венесуэла", "парагвай"
        }
    };

    Scanner scan = new Scanner(System.in);
    Random random = new Random();

    PrintStream printStream;

    public static void main(String[] args) {
        DrawingGallow drawingGallow = new DrawingGallow();
//        for (int i = 0; i < 6; i++) {
//            drawingGallow.increment();
//            drawingGallow.printGallows(System.out);
//        }
//
//        drawingGallow.setCountError(0);

        int category = Chosen.chooseCategory(scan, System.out, random);
        int level = Chosen.chooseLevel(scan, System.out, random);

        ArrayList<String> arr = new ArrayList<>();

        if (category == Config.CATEGORY_ONE) {
            if (level == Config.LEVEL_ONE) {
                arr.addAll(List.of(sportsWords[0]));
            } else if (level == Config.LEVEL_TWO) {
                arr.addAll(List.of(sportsWords[1]));
            } else {
                arr.addAll(List.of(sportsWords[2]));
            }

        } else if (category == Config.CATEGORY_TWO) {
            if (level == Config.LEVEL_ONE) {
                arr.addAll(List.of(animalsWords[0]));
            } else if (level == Config.LEVEL_TWO) {
                arr.addAll(List.of(animalsWords[1]));
            } else {
                arr.addAll(List.of(animalsWords[2]));
            }
        } else if (category == Config.CATEGORY_THREE) {
            if (level == Config.LEVEL_ONE) {
                arr.addAll(List.of(natureWords[0]));
            } else if (level == Config.LEVEL_TWO) {
                arr.addAll(List.of(natureWords[1]));
            } else {
                arr.addAll(List.of(natureWords[2]));
            }

        } else {
            if (level == 1) {
                arr.addAll(List.of(countriesWords[0]));
            } else if (level == 2) {
                arr.addAll(List.of(countriesWords[1]));
            } else {
                arr.addAll(List.of(countriesWords[2]));
            }
        }
        //System.out.println(arr);
        //----------

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
        LogicGame.play(drawingGallow, ourWord, foreignStr,
            cloneForeignStr, System.out, scan);

        //-----------------------
        scan.close();
    }
}
