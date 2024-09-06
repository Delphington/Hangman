package backend.academy;

import java.io.PrintStream;

public class DrawingGallow {
    private static final int MAXERROR = 7;
    private int countError = 0;
    private boolean currentGame = true;

    private final int[] arr = {1, 2, 3, 4, 5, 6};

    public void setCountError(int countError) {
        this.countError = countError;
    }

    public boolean isCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(boolean currentGame) {
        this.currentGame = currentGame;
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
        printStream.println("ERORR: " + countError);

        printStream.println("  _ _ _ _ _ _");
        for (int i = 0; i < MAXERROR - countError; i++) {
            printStream.print("|");
            if (i == 0) {
                //7 палочек
                switch (countError) {
                    case Config.FIRST_CASE:
                        printStream.println(FIRSTSTRING);
                        printStream.print(SECONDSTRING);
                        break;

                    case Config.SECOND_CASE:
                        printStream.println(FIRSTSTRING);
                        printStream.println(SECONDSTRING);
                        printStream.print(THIRDSTRING);
                        break;

                    case Config.THIRD_CASE:
                        printStream.println(FIRSTSTRING);
                        printStream.println(SECONDSTRING);
                        printStream.print(THIRDSTRING);
                        printStream.println(FOURTHSTRING);
                        printStream.print(HELPSTRING);
                        break;

                    case Config.FOURTH_CASE:
                        printStream.println(FIRSTSTRING);
                        printStream.println(SECONDSTRING);
                        printStream.println(FIFTHSTRING);
                        printStream.println(HELPSTRING);
                        printStream.print(HELPSTRING);
                        break;

                    case Config.FIFTH_CASE:
                        printStream.println(FIRSTSTRING);
                        printStream.println(SECONDSTRING);
                        printStream.println(FIFTHSTRING);
                        printStream.println(THIRDSTRING);
                        printStream.println(HELPSTRING);
                        printStream.print(HELPSTRING);
                        break;

                    case Config.SIXTH_CASE:
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
                        // Обработка случая, если countError не соответствует ни одному элементу массива
                        break;
                }


            }
            printStream.println();
        }
    }
}
