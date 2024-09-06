package backend.academy;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class LogicGame {

    public static void play(
        DrawingGallow drawingGallow,
        String ourWord, StringBuilder foreignStr,
        StringBuilder cloneForeignStr,
        PrintStream printStream,
        Scanner scan
    ) {

        System.out.println("str = " + ourWord + "  CloneStr = " + foreignStr + "StrNew: " + cloneForeignStr);

        boolean glag = true;
        ArrayList<String> letter = new ArrayList<>();
        System.out.println("Количество ваших попыток: " + (6 - drawingGallow.getCountError()));

        while (glag) {
            // System.out.println("Количество ваших попыток: " + (6 - gr.getCount_Error()));
            System.out.println("Использованные буквы: " + letter.toString());

            System.out.println("Введите букву");
            String g = scan.nextLine().trim().toLowerCase();

            if (CheckDate.checkChar(g)) {  //проверка на норм символы
                char symbol = g.charAt(0);
                if (letter.contains(Character.toString(symbol))) {
                    System.out.println("Внимание! Вы уже вводили эту букву!");
                } else {

                    letter.add(Character.toString(symbol));
                    if (ourWord.indexOf(String.valueOf(symbol)) == -1) {
                        System.out.println("Такой буквы нет в слове");
                        drawingGallow.increment();
                        drawingGallow.printGallows(System.out);
                        System.out.println("Количество ваших попыток: " + (6 - drawingGallow.getCountError()));
                        if (drawingGallow.getCountError() == 6) {
                            System.out.println("----------------WE LOSED -----------------");
                            glag = false;
                            drawingGallow.setCountError(0);

                            break;
                        }
                    } else {
                        //Случай, когда пользователь смог отгадать буквы
                        for (int i = 0; i < cloneForeignStr.length(); i++) {
                            if (symbol == cloneForeignStr.charAt(i)) {
                                foreignStr.setCharAt(i, symbol);
//                                        if(CloneStr.charAt(i+1) ==' '){
//                                            CloneStr.deleteCharAt(i+1);
//                                        }
                            }
                        }
                        System.out.println(foreignStr);
                    }

                    if (foreignStr.indexOf("_") == -1) {
                        System.out.println("Вы отгадали слово! ");
                        glag = false;
                        drawingGallow.setCountError(0);
                    }
                }

            } else {
                System.out.println("Не корректный ввод");
            }
        }
    }
}
