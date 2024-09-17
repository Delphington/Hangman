package backend.academy.samples;

import backend.academy.LogicGame;
import backend.academy.SrvInitialization;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LogicGameTest {

    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;
    private Scanner scanner;

//    @BeforeEach
//    void setUp() {
//        outputStream = new ByteArrayOutputStream();
//        originalOut = System.out;
//        System.setOut(new PrintStream(outputStream));
//        scanner = new Scanner(System.in);
//    }

//    @Test
//    void testPlayCorrectGuess() {
//        String ourWord = "test";
//        StringBuilder foreignStr = new StringBuilder("_____");
//        StringBuilder cloneForeignStr = new StringBuilder("test");
//
//        // Настраиваем ввод пользователя
//        when(scanner.nextLine()).thenReturn("t", "e", "s", "t");
//
//        LogicGame.play(ourWord, foreignStr, cloneForeignStr, printStream, scanner);
//
//        assertEquals("Вы отгадали слово! ", outputStreamCaptor.toString().trim());
//    }

//    @Test
//    void testPlayIncorrectGuess() {
//        String ourWord = "test";
//        StringBuilder foreignStr = new StringBuilder("_____");
//        StringBuilder cloneForeignStr = new StringBuilder("test");
//
//        // Настраиваем ввод пользователя
//        when(scanner.nextLine()).thenReturn("a", "b", "c", "d", "e", "f", "h"); // 6 неверных попытки
//
//        LogicGame.play(ourWord, foreignStr, cloneForeignStr, originalOut, scanner);
//
//        assertTrue(outputStream.toString().contains("WE LOSED"));
//    }

//
//    @Test
//    void testPlayLoseCondition() {
//        String ourWord = "test";
//        StringBuilder foreignStr = new StringBuilder("_____");
//        StringBuilder cloneForeignStr = new StringBuilder(ourWord);
//        PrintStream printStream = System.out;
//
//        // Simulate user input that leads to losing the game
//        String input = "a\nb\nc\nd\n"; // 4 incorrect guesses
//        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
//
//        // Call the method
//        LogicGame.play(ourWord, foreignStr, cloneForeignStr, printStream, scanner);
//
//        // Check that the losing message was printed
//        assertTrue(outputStream.toString().contains("WE LOSED"));
//    }
//
//    @AfterEach
//    void tearDown() {
//        System.setOut(originalOut);
//    }
}



//
//    @Test
//    void testPlayWithHint() {
//
//        String ourWord = "test";
//        StringBuilder foreignStr = new StringBuilder("_____");
//        StringBuilder cloneForeignStr = new StringBuilder("test");
//        LogicGame.play(ourWord, foreignStr, cloneForeignStr, printStream, scanner);
//
//        // Настраиваем ввод пользователя
//        when(scanner.nextLine()).thenReturn("a", "L", "hint", "t", "e", "s");
//
//       // assertTrue(outputStreamCaptor.toString().contains("Подсказка:")); // Проверяйте, что подсказка в выводе
//
//
//        System.out.println(outputStreamCaptor.toString());
//
//        assertTrue(outputStreamCaptor.toString().contains("Вы отгадали слово! "));
//
//
//
//        // Получите слово и подсказку из SrvInitialization
////        Map<String, String> wordAndHint = SrvInitialization.getWordAndHint(); // Замените "getWordAndHint()" на правильное имя метода
////
////        // Проверьте, что слово и подсказка не null
////        if (wordAndHint != null) {
////            String word = wordAndHint.get("word"); // Замените "word" на ключ слова в Map
////            String hint = wordAndHint.get("hint"); // Замените "hint" на ключ подсказки в Map
////
////            // Запустите игру
////            LogicGame.play(word, foreignStr, cloneForeignStr, printStream, scanner);
////
////            // Проверьте выходные данные
////            assertTrue(outputStreamCaptor.toString().contains("Подсказка: " + hint)); // Проверяйте, что подсказка в выводе
////        } else {
////            fail("getWordAndHint() вернул null");
////        }
//
//
//




        /*
        String ourWord = "test";
        StringBuilder foreignStr = new StringBuilder("_____");
        StringBuilder cloneForeignStr = new StringBuilder("test");

        // Настраиваем ввод пользователя
        when(scanner.nextLine()).thenReturn("a", "hint", "t", "e", "s", "t");

        LogicGame.play(ourWord, foreignStr, cloneForeignStr, printStream, scanner);

       // assertTrue(outputStreamCaptor.toString().contains("Вы отгадали слово! "));
        assertTrue(outputStreamCaptor.toString().contains("Подсказка: "));

         */
    //}
//
