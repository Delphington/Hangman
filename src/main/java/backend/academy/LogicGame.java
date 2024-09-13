package backend.academy;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class LogicGame {
    private LogicGame() {
    }

    public static void play(
        DrawingGallow drawingGallow, String ourWord, StringBuilder foreignStr,
        StringBuilder cloneForeignStr, PrintStream printStream, Scanner scan
    ) {

        char symbol;

       // printStream.println(foreignStr);

        ArrayList<String> letter = new ArrayList<>(); //Массив для использованных букв

        printStream.println(Config.REMAINING_ATTEMPTS + (Config.TOTAL_ATTEMPTS - drawingGallow.getCountError()));

        printStream.println(foreignStr); //Вывод маски
        while (true) {

            //Проверка корректности ввода символа
            while (true) {
                printStream.println("Введите букву: ");
                String temp = scan.nextLine().trim().toLowerCase();
                if (CheckData.checkChar(temp)) {  //проверка на норм символы
                    symbol = temp.charAt(0);
                    if (letter.contains(Character.toString(symbol))) {
                        printStream.println("Внимание! Вы уже вводили эту букву, попробуйте еще раз!");
                    } else {
                        letter.add(Character.toString(symbol));
                        break;
                    }
                } else {
                    printStream.print("Ошибка! ");
                }
            }

            //Пользователь ввел буквы, которой нет в слове
            if (ourWord.indexOf(String.valueOf(symbol)) == -1) {
                drawingGallow.increment();
                drawingGallow.printGallows(System.out);
                //Вывод оставшихся попыток
                printStream.println(
                    Config.REMAINING_ATTEMPTS + (Config.TOTAL_ATTEMPTS - drawingGallow.getCountError()));

                //Вывод подсказки
                if (drawingGallow.getCountError() == Config.ERROR_CASE_1) {
                    printStream.println("Подсказка: " + SrvInitialization.getWordAndHint().get(ourWord));
                   // printStream.println(foreignStr); //Вывод маски
                } else if (drawingGallow.getCountError() == Config.TOTAL_ATTEMPTS) {
                    printStream.println("----------------WE LOSED -----------------");
                    printStream.println("# Загаданное слово: " + ourWord);
                    drawingGallow.setCountError(0);
                    break;
                }
                printStream.println(foreignStr); //Вывод маски

            } else {
                // printStream.println(foreignStr);

                //Случай, когда пользователь смог отгадать буквы
                for (int i = 0; i < cloneForeignStr.length(); i++) {
                    if (symbol == cloneForeignStr.charAt(i)) {
                        foreignStr.setCharAt(i, symbol);
                    }
                }
                printStream.println(foreignStr);
            }

            if (foreignStr.indexOf("_") == -1) {
                printStream.println("Вы отгадали слово! ");
                drawingGallow.setCountError(0);
                break;
            }
        }
    }
}
