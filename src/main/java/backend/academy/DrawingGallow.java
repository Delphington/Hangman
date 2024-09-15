package backend.academy;

import java.io.PrintStream;

public final class DrawingGallow implements Constants {
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

    private enum GallowEnum {
        STEP_1("           |"),
        STEP_2("|           0"),
        STEP_3("|          /"),
        STEP_4(" \\"),
        STEP_5("|          /|\\"),
        STEP_HELP("|");

        public String getValue() {
            return value;
        }

        private final String value;

        GallowEnum(String value) {
            this.value = value;
        }
    }

    public void printGallows(PrintStream printStream) {
        if (countError <= Config.TOTAL_ATTEMPTS && countError > 0) {

            printStream.print("  _ _ _ _ _ _\n");
            for (int i = 0; i <= Config.TOTAL_ATTEMPTS - countError; i++) {
                printStream.print(GallowEnum.STEP_HELP.getValue());
                if (i == 0) {
                    //Разрисовка висилица в зависимости от количества ошибок
                    switch (countError) {
                        case ERROR_CASE_1:
                            printStream.print(GallowEnum.STEP_1.getValue() + "\n");
                            printStream.print(GallowEnum.STEP_2.getValue());
                            break;

                        case ERROR_CASE_2:
                            printStream.print(GallowEnum.STEP_1.getValue() + "\n");
                            printStream.print(GallowEnum.STEP_2.getValue() + "\n");
                            printStream.print(GallowEnum.STEP_3.getValue());
                            break;

                        case ERROR_CASE_3:
                            printStream.print(GallowEnum.STEP_1.getValue() + "\n");
                            printStream.print(GallowEnum.STEP_2.getValue() + "\n");
                            printStream.print(GallowEnum.STEP_3.getValue());
                            printStream.print(GallowEnum.STEP_4.getValue() + "\n");
                            printStream.print(GallowEnum.STEP_HELP.getValue());
                            break;

                        case ERROR_CASE_4:
                            printStream.print(GallowEnum.STEP_1.getValue() + "\n");
                            printStream.print(GallowEnum.STEP_2.getValue() + "\n");
                            printStream.print(GallowEnum.STEP_5.getValue() + "\n");
                            printStream.print(GallowEnum.STEP_HELP.getValue() + "\n");
                            printStream.print(GallowEnum.STEP_HELP.getValue());
                            break;

                        case ERROR_CASE_5:
                            printStream.print(GallowEnum.STEP_1.getValue() + "\n");
                            printStream.print(GallowEnum.STEP_2.getValue() + "\n");
                            printStream.print(GallowEnum.STEP_5.getValue() + "\n");
                            printStream.print(GallowEnum.STEP_3.getValue() + "\n");
                            printStream.print(GallowEnum.STEP_HELP.getValue() + "\n");
                            printStream.print(GallowEnum.STEP_HELP.getValue());
                            break;

                        case ERROR_CASE_6:
                            printStream.print(GallowEnum.STEP_1.getValue() + "\n");
                            printStream.print(GallowEnum.STEP_2.getValue() + "\n");
                            printStream.print(GallowEnum.STEP_5.getValue() + "\n");
                            printStream.print(GallowEnum.STEP_3.getValue());
                            printStream.print(GallowEnum.STEP_4.getValue() + "\n");
                            printStream.print(GallowEnum.STEP_HELP.getValue() + "\n");
                            printStream.print(GallowEnum.STEP_HELP.getValue() + "\n");
                            printStream.print(GallowEnum.STEP_HELP.getValue() + "\n");
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
