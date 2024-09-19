//package backend.academy.samples;
//
//import backend.academy.Capy;
//import backend.academy.LogicGame;
//import backend.academy.SrvInitialization;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import java.util.Map;
//import java.util.Scanner;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class LogicGameTest {
//
//    private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//    private PrintStream printStream;
//    private Scanner scanner;
//
//    @BeforeEach
//    void setUp() {
//        // Перенаправление стандартного вывода
//        outputStreamCaptor.reset();
//        printStream = new PrintStream(outputStreamCaptor);
//        scanner = Mockito.mock(Scanner.class);
//
//        System.setOut(new PrintStream(outputStreamCaptor));
//    }
//
//    @AfterEach
//    void tearDown() {
//        // Восстановление стандартного вывода
//        System.setOut(System.out);
//        scanner.close(); // Закрываем сканер
//    }
//
//    String ourWord;
//    StringBuilder foreignStr, cloneForeignStr;
//    String output;
//
//    @BeforeEach
//    void Initialization() {
//        ourWord = "игра";
//        foreignStr = new StringBuilder("_ _ _ _");
//        cloneForeignStr = new StringBuilder("и г р а");
//    }
//
//}
