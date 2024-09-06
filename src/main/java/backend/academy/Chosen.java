package backend.academy;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Chosen {
    public static Random random = new Random();

    private static int category = 0;
    private int level = 0;
    private static boolean f = true;

    static String line = null;

    public static int chooseCategory(Scanner scan, PrintStream printStream) {

        printStream.println("Выберите номер категории слов: \n"

            + "[" + Config.CATEGORY_ONE + "] Спорт \n"
            + "[" + Config.CATEGORY_TWO + "] Животные \n"
            + "[" + Config.CATEGORY_THREE + "] Природа \n"
            + "[" + Config.CATEGORY_FOUR + "] Страны"

        );

        while (true) {
            line = scan.nextLine().trim();

            if (line.isEmpty()) {
                return random.nextInt(Config.RANDOM_CATEGORY_MAX) + Config.RANDOM_CATEGORY_MIN;
            } else {
                try {
                    category = Integer.parseInt(line);
                    if (category >= Config.RANDOM_CATEGORY_MIN && category <= Config.RANDOM_CATEGORY_MAX) {
                        return category;
                    }
                    printStream.println(Config.WARNING_MESSAGE);

                } catch (Exception e) {
                    printStream.println(Config.WARNING_MESSAGE);

                }

            }

        }

//        while (true) {
//            try {
//                //Первоначально определеляем
//                if (f) {
//                    category = Integer.parseInt(s);
//                    f = false;
//                } else {
//                    category = scan.nextInt();
//                }
//
//                if (category < Config.RANDOM_CATEGORY_MIN || category > Config.RANDOM_CATEGORY_MAX) {
//                    printStream.println("Ошибка! Вы ввели неподходящее число.");
//                    printStream.println("Введите цифру: ");
//
//                } else {
//                    break;
//                }
//            } catch (Exception e) {
//                printStream.println("Ошибка! Вы ввели не число");
//                printStream.println("Введите цифру еще раз: ");
//                scan.next(); //Очистка не корретного ввода
//            }
//        }
//        f = true;
//
//        return category;
    }
}
