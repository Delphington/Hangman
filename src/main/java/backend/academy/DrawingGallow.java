package backend.academy;

import java.io.PrintStream;

public final class DrawingGallow {

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

    public void printGallows(PrintStream printStream) {
        if (countError <= Config.TOTAL_ATTEMPTS && countError > 0) {

            printStream.print("  _ _ _ _ _ _\n");
            for (int i = 0; i <= Config.TOTAL_ATTEMPTS - countError; i++) {
                printStream.print(Gallow.STEP_HELP.getValue());
                if (i == 0) {
                    //Разрисовка висилица в зависимости от количества ошибок
                    switch (countError) {
                        case Config.ERROR_CASE_1:
                            printStream.print(Gallow.STEP_1.getValue() + "\n");
                            printStream.print(Gallow.STEP_2.getValue());
                            break;

                        case Config.ERROR_CASE_2:
                            printStream.print(Gallow.STEP_1.getValue() + "\n");
                            printStream.print(Gallow.STEP_2.getValue() + "\n");
                            printStream.print(Gallow.STEP_3.getValue());
                            break;

                        case Config.ERROR_CASE_3:
                            printStream.print(Gallow.STEP_1.getValue() + "\n");
                            printStream.print(Gallow.STEP_2.getValue() + "\n");
                            printStream.print(Gallow.STEP_3.getValue());
                            printStream.print(Gallow.STEP_4.getValue() + "\n");
                            printStream.print(Gallow.STEP_HELP.getValue());
                            break;

                        case Config.ERROR_CASE_4:
                            printStream.print(Gallow.STEP_1.getValue() + "\n");
                            printStream.print(Gallow.STEP_2.getValue() + "\n");
                            printStream.print(Gallow.STEP_5.getValue() + "\n");
                            printStream.print(Gallow.STEP_HELP.getValue() + "\n");
                            printStream.print(Gallow.STEP_HELP.getValue());
                            break;

                        case Config.ERROR_CASE_5:
                            printStream.print(Gallow.STEP_1.getValue() + "\n");
                            printStream.print(Gallow.STEP_2.getValue() + "\n");
                            printStream.print(Gallow.STEP_5.getValue() + "\n");
                            printStream.print(Gallow.STEP_3.getValue() + "\n");
                            printStream.print(Gallow.STEP_HELP.getValue() + "\n");
                            printStream.print(Gallow.STEP_HELP.getValue());
                            break;

                        case Config.ERROR_CASE_6:
                            printStream.print(Gallow.STEP_1.getValue() + "\n");
                            printStream.print(Gallow.STEP_2.getValue() + "\n");
                            printStream.print(Gallow.STEP_5.getValue() + "\n");
                            printStream.print(Gallow.STEP_3.getValue());
                            printStream.print(Gallow.STEP_4.getValue() + "\n");
                            printStream.print(Gallow.STEP_HELP.getValue() + "\n");
                            printStream.print(Gallow.STEP_HELP.getValue() + "\n");
                            printStream.print(Gallow.STEP_HELP.getValue() + "\n");
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
