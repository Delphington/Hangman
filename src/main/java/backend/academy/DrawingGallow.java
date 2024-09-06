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
        if (countError <= Config.TOTAL_ATTEMPTS && countError > 0) {

            printStream.print("  _ _ _ _ _ _\n");
            for (int i = 0; i <= Config.TOTAL_ATTEMPTS - countError; i++) {
                printStream.print("|");
                if (i == 0) {
                    //Разрисовка висилица в зависимости от количества ошибок
                    switch (countError) {
                        case Config.ERROR_FIRST_CASE:
                            printStream.print(FIRSTSTRING + "\n");
                            printStream.print(SECONDSTRING);
                            break;

                        case Config.ERROR_SECOND_CASE:
                            printStream.print(FIRSTSTRING + "\n");
                            printStream.print(SECONDSTRING + "\n");
                            printStream.print(THIRDSTRING);
                            break;

                        case Config.ERROR_THIRD_CASE:
                            printStream.print(FIRSTSTRING + "\n");
                            printStream.print(SECONDSTRING + "\n");
                            printStream.print(THIRDSTRING);
                            printStream.print(FOURTHSTRING + "\n");
                            printStream.print(HELPSTRING);
                            break;

                        case Config.ERROR_FOURTH_CASE:
                            printStream.print(FIRSTSTRING + "\n");
                            printStream.print(SECONDSTRING + "\n");
                            printStream.print(FIFTHSTRING + "\n");
                            printStream.print(HELPSTRING + "\n");
                            printStream.print(HELPSTRING);
                            break;

                        case Config.ERROR_FIFTH_CASE:
                            printStream.print(FIRSTSTRING + "\n");
                            printStream.print(SECONDSTRING + "\n");
                            printStream.print(FIFTHSTRING + "\n");
                            printStream.print(THIRDSTRING + "\n");
                            printStream.print(HELPSTRING + "\n");
                            printStream.print(HELPSTRING);
                            break;

                        case Config.ERROR_SIXTH_CASE:
                            printStream.print(FIRSTSTRING + "\n");
                            printStream.print(SECONDSTRING + "\n");
                            printStream.print(FIFTHSTRING + "\n");
                            printStream.print(THIRDSTRING);
                            printStream.print(FOURTHSTRING + "\n");
                            printStream.print(HELPSTRING + "\n");
                            printStream.print(HELPSTRING + "\n");
                            printStream.print(HELPSTRING + "\n");
                            break;

                        default:
                            printStream.println("Error");
                            break;
                    }
                }
                printStream.print("\n");
            }
        }
    }
}
