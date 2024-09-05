package backend.academy;

public class DrawingGallow {

    private int countError = 0;
    private boolean currentGame = true;

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

    public void printGallows() {
        if (countError > 0 && countError < 7) {
            System.out.println("  _ _ _ _ _ _");
            for (int i = 0; i < 7 - countError; i++) {
                System.out.print("|");
                if (i == 0) {
                    //7 палочек
                    if (countError == 1) {
                        System.out.println("           |");
                        System.out.print("|           0");
                    } else if (countError == 2) {
                        //7
                        System.out.println("           |");
                        System.out.println("|           0");
                        System.out.print("|          /");
                    } else if (countError == 3) {
                        System.out.println("           |");
                        System.out.println("|           0");
                        System.out.println("|          / \\");
                        System.out.print("|");
                    } else if (countError == 4) {
                        System.out.println("           |");
                        System.out.println("|           0");
                        System.out.println("|          /|\\");
                        System.out.println("|           | ");
                        System.out.print("|");

                    } else if (countError == 5) {
                        System.out.println("           |");
                        System.out.println("|           0");
                        System.out.println("|          /|\\");
                        System.out.println("|           | ");
                        System.out.println("|          / ");
                        System.out.print("|");

                    } else if (countError == 6) {
                        currentGame = false;
                        System.out.println("           |");
                        System.out.println("|           0");
                        System.out.println("|          /|\\");
                        System.out.println("|           | ");
                        System.out.println("|          / \\");
                        System.out.println("|");
                        System.out.print("|");
                    }
                }
                System.out.println();
            }
            System.out.println("----");

        } else {
            System.out.println("Error: нас здесь быть не должно");
        }
    }
}
