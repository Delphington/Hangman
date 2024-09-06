package backend.academy;

import java.io.PrintStream;

public class DrawingGallow {
    private int countError = 0;

    public void setCountError(int countError) {
        this.countError = countError;
    }

    public int getCountError() {
        return countError;
    }

    public void increment() {
        countError++;
    }

    private final static String FIRSTSTRING = "           |";
    private final static String SECONDSTRING = "|           0";
    private final static String THIRDSTRING = "|          /";
    private final static String FOURTHSTRING = " \\";
    private final static String FIFTHSTRING = "|          /|\\";
    private final static String HELPSTRING = "|";

    public void printGallows(PrintStream printStream) {

        printStream.println("  _ _ _ _ _ _");
        for (int i = 0; i <= Config.TOTAL_ATTEMPTS - countError; i++) {
            printStream.print("|");
            if (i == 0) {
                //Разрисовка висилица в зависимости от количества ошибок
                switch (countError) {
                    case Config.ERROR_FIRST_CASE:
                        printStream.println(FIRSTSTRING);
                        printStream.print(SECONDSTRING);
                        break;

                    case Config.ERROR_SECOND_CASE:
                        printStream.println(FIRSTSTRING);
                        printStream.println(SECONDSTRING);
                        printStream.print(THIRDSTRING);
                        break;

                    case Config.ERROR_THIRD_CASE:
                        printStream.println(FIRSTSTRING);
                        printStream.println(SECONDSTRING);
                        printStream.print(THIRDSTRING);
                        printStream.println(FOURTHSTRING);
                        printStream.print(HELPSTRING);
                        break;

                    case Config.ERROR_FOURTH_CASE:
                        printStream.println(FIRSTSTRING);
                        printStream.println(SECONDSTRING);
                        printStream.println(FIFTHSTRING);
                        printStream.println(HELPSTRING);
                        printStream.print(HELPSTRING);
                        break;

                    case Config.ERROR_FIFTH_CASE:
                        printStream.println(FIRSTSTRING);
                        printStream.println(SECONDSTRING);
                        printStream.println(FIFTHSTRING);
                        printStream.println(THIRDSTRING);
                        printStream.println(HELPSTRING);
                        printStream.print(HELPSTRING);
                        break;

                    case Config.ERROR_SIXTH_CASE:
                        printStream.println(FIRSTSTRING);
                        printStream.println(SECONDSTRING);
                        printStream.println(FIFTHSTRING);
                        printStream.print(THIRDSTRING);
                        printStream.println(FOURTHSTRING);
                        printStream.println(HELPSTRING);
                        printStream.println(HELPSTRING);
                        printStream.println(HELPSTRING);
                        break;

                    default:
                        printStream.println("Error");
                        break;
                }
            }
            printStream.println();
        }
    }
}
