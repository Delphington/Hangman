package backend.academy;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {
    public static void main(String[] args) {
        DrawingGallow g = new DrawingGallow();
        final int maxError = 6;
        for (int i = 0; i < maxError; i++) {
            g.increment();
            g.printGallows(System.out);
        }

    }
}
