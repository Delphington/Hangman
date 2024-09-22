package backend.academy;

import backend.academy.game.StartGame;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {

    //Уровень 1: слова из букв 1-4
    //Уровень 2: слова из букв 5-8
    //Уровень 3: слова из букв 9-14

    public static void main(String[] args) {
        StartGame.startGame();
    }
}
