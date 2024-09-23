package backend.academy.samples;

import backend.academy.game.LogicGame;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LogicGameTest {

    private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private PrintStream printStream;
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        // Перенаправление стандартного вывода
        outputStreamCaptor.reset();
        printStream = new PrintStream(outputStreamCaptor);
        scanner = Mockito.mock(Scanner.class);

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        // Восстановление стандартного вывода
        System.setOut(System.out);
        scanner.close(); // Закрываем сканер
    }

    String ourWord;
    StringBuilder foreignStr, cloneForeignStr;
    String output;

    @BeforeEach
    void Initialization() {
        ourWord = "игра";
        foreignStr = new StringBuilder("_ _ _ _");
        cloneForeignStr = new StringBuilder("и г р а");
    }

    @Test
    void alreadyExistSymbolWin() {
        when(scanner.nextLine()).thenReturn("и", "и", "г", "р", "а");
        LogicGame.play(ourWord, foreignStr, cloneForeignStr, printStream, scanner);
        output = outputStreamCaptor.toString().trim(); // Получаем вывод
        assertTrue(output.contains("Вы выиграли!"), "Expected output not found: " + output);
        assertTrue(output.contains("Внимание! Вы уже вводили эту букву, попробуйте еще раз!"),
            "Expected output not found: " + output);
        // Проверяем, что сколько раз был вызван метод nextLine
        verify(scanner, times(5)).nextLine();
    }

    @Test
    void alreadyExistSymbolLose() {
        //Повторение символов и проигрыш
        when(scanner.nextLine()).thenReturn("и", "и", "г", "t", "f", "h", "j", "k", "l");
        LogicGame.play(ourWord, foreignStr, cloneForeignStr, printStream, scanner);
        output = outputStreamCaptor.toString().trim(); // Получаем вывод
        assertTrue(output.contains("Вы проиграли"), "Expected output not found: " + output);
        verify(scanner, times(9)).nextLine();
    }
}
