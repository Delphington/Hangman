package backend.academy;

import lombok.experimental.UtilityClass;


@UtilityClass
public class Main {
    public static void main(String[] args) {
        DrawingGallow g = new DrawingGallow();
        for(int i=0; i<6; i++){
            g.increment();
            g.printGallows();
        }
    }
}
