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
        boolean isUsedHint = false;

        ArrayList<String> letter = new ArrayList<>(); //Массив для использованных букв

        printStream.println(Config.REMAINING_ATTEMPTS + (Config.TOTAL_ATTEMPTS - drawingGallow.getCountError()));

        printStream.println(foreignStr); //Вывод маски
        while (true) {

            //Проверка корректности ввода символа
            while (true) {
                if (drawingGallow.getCountError() > 0 && !isUsedHint) {
                    printStream.print("Если нужна подсказка введите [hint] или ");
                }
                printStream.println("Введите букву для загаданного слова: ");
                String temp = scan.nextLine().trim().toLowerCase();

                //Вывод подсказки(Подсказка предлагается, когда пользователь совершил ошибку)
                if (temp.equals("hint")) {
                    printStream.println("Подсказка: " + SrvInitialization.getWordAndHint().get(ourWord));
                    isUsedHint = true;

                } else if (CheckData.checkChar(temp)) {  //проверка на норм символы
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

                if (drawingGallow.getCountError() == Config.TOTAL_ATTEMPTS) {
                    printStream.println("----------------WE LOSED -----------------");
                    printStream.println("# Загаданное слово: " + ourWord);
                    drawingGallow.setCountError(0);
                    isUsedHint = false;
                    break;
                }
                printStream.println(foreignStr); //Вывод маски

            } else {

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
                isUsedHint = false;
                break;
            }
        }
    }
}
