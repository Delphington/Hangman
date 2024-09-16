package backend.academy;

import lombok.Getter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public final class LogicGame {
    private LogicGame() {
    }

    @Getter private static int countError = 0;

    public static void setCountError(int c) {
        countError = c;
    }

    public int getCountError() {
        return countError;
    }


    public static void play(
        DrawingGallow drawingGallow, String ourWord, StringBuilder foreignStr,
        StringBuilder cloneForeignStr, PrintStream printStream, Scanner scan
    ) {

        char symbol;
        boolean isUsedHint = false;

        ArrayList<String> usedLetters = new ArrayList<>(); //Массив для использованных букв

        printStream.println(Config.REMAINING_ATTEMPTS + (Config.TOTAL_ATTEMPTS - countError));

        printStream.println(foreignStr); //Вывод маски
        while (true) {

            //Проверка корректности ввода символа
            while (true) {
                if (countError > 0 && !isUsedHint) {
                    printStream.print("Если нужна подсказка введите [hint] или ");
                }
                printStream.println("Введите букву для загаданного слова: ");

                String temp = CheckData.checkString(scan.nextLine());

                //Вывод подсказки(Подсказка предлагается, когда пользователь совершил ошибку)
                if (temp.equals("hint")) {
                    printStream.println("Подсказка: " + SrvInitialization.getWordAndHint().get(ourWord));
                    isUsedHint = true;

                } else if (CheckData.checkChar(temp)) {  //проверка на норм символы
                    symbol = temp.charAt(0);
                    if (usedLetters.contains(Character.toString(symbol))) {
                        printStream.println("Внимание! Вы уже вводили эту букву, попробуйте еще раз!");
                    } else {
                        usedLetters.add(Character.toString(symbol));
                        break;
                    }
                } else {
                    printStream.print("Ошибка! ");
                }
            }

            //Пользователь ввел буквы, которой нет в слове
            if (ourWord.indexOf(String.valueOf(symbol)) == -1) {

                countError ++;
                drawingGallow.printGallows(System.out, countError);

                //Вывод оставшихся попыток
                printStream.println(
                    Config.REMAINING_ATTEMPTS + (Config.TOTAL_ATTEMPTS - countError));

                if (countError == Config.TOTAL_ATTEMPTS) {
                    printStream.println("----------------WE LOSED -----------------");
                    printStream.println("# Загаданное слово: " + ourWord);

                    countError = 0;
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
                countError = 0;
                isUsedHint = false;
                break;
            }
        }
    }
}
