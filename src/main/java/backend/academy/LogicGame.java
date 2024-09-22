package backend.academy;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import lombok.Setter;

public final class LogicGame implements StringConst {
    private LogicGame() {
    }

    @Setter
    private static int countError = 0; //Счетчик ошибок

    /**
     * Метод для запуска игры.
     *
     * @param ourWord           Загаданное слово. (игра)
     * @param foreignStr        Строка, отображающая текущее состояние слова
     *                          с замененными буквами  и добавленными пробелами (_ _ _ _).
     * @param cloneForeignStr   Клонированная строка для проверки угаданных букв (и г р а).
     * @param printStream       Поток для вывода сообщений пользователю.
     * @param scan              Объект Scanner для считывания ввода пользователя.
     */

    @SuppressWarnings("all")
    public static void play(
        String ourWord, StringBuilder foreignStr,
        StringBuilder cloneForeignStr, PrintStream printStream, Scanner scan) {

        char symbol;
        boolean isUsedHint = false;

        ArrayList<String> usedLetters = new ArrayList<>(); //Массив для использованных букв

        printStream.println(REMAINING_ATTEMPTS + (Config.TOTAL_ATTEMPTS - countError));

        printStream.println(foreignStr); //Вывод маски
        while (true) {

            //Проверка корректности ввода символа
            while (true) {
                String temp = null;
                if (countError > 0 && !isUsedHint) {
                    printStream.print(MESSAGE_HINT);
                }
                printStream.println(MESSAGE_ENTER_CHAR);

                try {
                    temp = CheckData.checkString(scan.nextLine());
                } catch (NoSuchElementException e) {
                    printStream.println(MESSAGE_STRING_NULL);
                }

                //Вывод подсказки(Подсказка предлагается, когда пользователь совершил ошибку)
                if (temp != null && temp.equals("hint") && countError > 0) {
                    printStream.println("Подсказка: " + SrvWorkWord.getHint());
                    isUsedHint = true;

                } else if (temp != null && CheckData.checkChar(temp)) {  //проверка на норм символы
                    symbol = temp.charAt(0);
                    if (usedLetters.contains(Character.toString(symbol))) {
                        printStream.println(WARNING_SAME_CHAR);
                    } else {
                        usedLetters.add(Character.toString(symbol));
                        break;
                    }
                } else {
                    printStream.print(ERROR_MESSAGE);
                }
            }

            //Пользователь ввел буквы, которой нет в слове
            if (ourWord.indexOf(String.valueOf(symbol)) == -1) {
                countError++;
                DrawingGallow.printGallows(System.out, countError);

                //Вывод оставшихся попыток
                printStream.println(REMAINING_ATTEMPTS + (Config.TOTAL_ATTEMPTS - countError));

                if (countError == Config.TOTAL_ATTEMPTS) {
                    printStream.println(MESSAGE_LOSE);
                    printStream.println(MESSAGE_HIDDEN_WORD + ourWord);

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
                printStream.println(MESSAGE_WIN);
                countError = 0;
                isUsedHint = false;
                break;
            }
        }
    }
}
