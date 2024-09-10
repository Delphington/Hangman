package backend.academy.samples;

import backend.academy.Chosen;
import backend.academy.Config;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.security.SecureRandom;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ChosenTest {

    private Scanner scanner;
    private PrintStream printStream;
    private SecureRandom random;
    private int category;
    private int level;
    private boolean curr;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpS() {
        // Перенаправляем стандартный вывод в ByteArrayOutputStream
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        // Восстанавливаем стандартный вывод
        System.setOut(originalOut);
    }

    //Создание иммитации для каждого объекта
    @BeforeEach
    public void setUp() {
        scanner = mock(Scanner.class);
        printStream = mock(PrintStream.class);
        random = mock(SecureRandom.class);
    }

    //Проверим числа, которые можно вводить
    @Test
    public void inputChooseCategoryValid() {
        when(scanner.nextLine()).thenReturn("1");
        category = Chosen.chooseCategory(scanner, printStream, random);
        assertEquals(1, category);

        when(scanner.nextLine()).thenReturn("2");
        category = Chosen.chooseCategory(scanner, printStream, random);
        assertEquals(2, category);

        when(scanner.nextLine()).thenReturn("3");
        category = Chosen.chooseCategory(scanner, printStream, random);
        assertEquals(3, category);

        when(scanner.nextLine()).thenReturn("4");
        category = Chosen.chooseCategory(scanner, printStream, random);
        assertEquals(4, category);

    }

    @Test
    public void inputChooseCategoryInvalid() {
        // Тест на выход за границу сверху
        when(scanner.nextLine()).thenReturn("5", "1");
        int category = Chosen.chooseCategory(scanner, printStream, random);
        assertEquals(1, category); // Сравним верное значение
        verify(printStream, times(1)).println(Config.WARNING_MESSAGE);

        // Выход снизу
        when(scanner.nextLine()).thenReturn("0", "1");
        category = Chosen.chooseCategory(scanner, printStream, random);
        assertEquals(1, category);
        verify(printStream, times(2)).println(Config.WARNING_MESSAGE);

        //Ввод спецеального символа
        when(scanner.nextLine()).thenReturn("№", "1");
        category = Chosen.chooseCategory(scanner, printStream, random);

        assertEquals(1, category);
        verify(printStream, times(3)).println(Config.WARNING_MESSAGE);

        //Ввод пробела
        when(scanner.nextLine()).thenReturn(" ", "1");
        category = Chosen.chooseCategory(scanner, printStream, random);
        assertEquals(1, category); // Сравним верное значение
        verify(printStream, times(4)).println(Config.WARNING_MESSAGE);

        //        //Ввод пустоты
        when(scanner.nextLine()).thenReturn("");
        when(random.nextInt(Config.RANDOM_CATEGORY_MAX)).thenReturn(1);

        // Act
        int actualCategory = Chosen.chooseCategory(scanner, printStream, random);

        // Assert
        assertEquals(1 + Config.RANDOM_CATEGORY_MIN, actualCategory);
    }

    @Test
    public void inputChooseLevelValid() {
        when(scanner.nextLine()).thenReturn("1");
        level = Chosen.chooseLevel(scanner, printStream, random);
        assertEquals(1, level);

        when(scanner.nextLine()).thenReturn("2");
        level = Chosen.chooseLevel(scanner, printStream, random);
        assertEquals(2, level);

        when(scanner.nextLine()).thenReturn("3");
        level = Chosen.chooseLevel(scanner, printStream, random);
        assertEquals(3, level);

    }

    @Test
    public void inputChooseLevelInvalid() {

        // Тест на выход за границу сверху
        when(scanner.nextLine()).thenReturn("5", "1");
        level = Chosen.chooseLevel(scanner, printStream, random);
        assertEquals(1, level);
        verify(printStream, times(1)).println(Config.WARNING_MESSAGE);

        // Выход снизу
        when(scanner.nextLine()).thenReturn("0", "1");
        level = Chosen.chooseLevel(scanner, printStream, random);
        assertEquals(1, level); // Сравним верное значение
        verify(printStream, times(2)).println(Config.WARNING_MESSAGE);

        //Ввод спецеального символа
        when(scanner.nextLine()).thenReturn("№", "1");
        level = Chosen.chooseLevel(scanner, printStream, random);
        assertEquals(1, level);
        verify(printStream, times(3)).println(Config.WARNING_MESSAGE);

        //Ввод пробела
        when(scanner.nextLine()).thenReturn(" ", "1");
        level = Chosen.chooseLevel(scanner, printStream, random);
        assertEquals(1, level);
        verify(printStream, times(4)).println(Config.WARNING_MESSAGE);

        //Ввод строки
        when(scanner.nextLine()).thenReturn("abs", "1");
        level = Chosen.chooseLevel(scanner, printStream, random);
        assertEquals(1, level);
        verify(printStream, times(5)).println(Config.WARNING_MESSAGE);

        //Ввод пустоты
        when(scanner.nextLine()).thenReturn("");
        when(random.nextInt(Config.RANDOM_CATEGORY_MAX)).thenReturn(1);

        int actualCategory = Chosen.chooseCategory(scanner, printStream, random);
        assertEquals(1 + Config.RANDOM_CATEGORY_MIN, actualCategory);
    }

    @Test
    public void chooseActionValid() {

        //Ввод Англичских букв
        when(scanner.nextLine()).thenReturn("E");
        curr = Chosen.chooseAction(printStream, scanner);
        assertEquals(false, curr);

        when(scanner.nextLine()).thenReturn("e");
        curr = Chosen.chooseAction(printStream, scanner);
        assertEquals(false, curr);

        //Ввод Русских букв
        when(scanner.nextLine()).thenReturn("Е");
        curr = Chosen.chooseAction(printStream, scanner);
        assertEquals(false, curr);

        when(scanner.nextLine()).thenReturn("е");
        curr = Chosen.chooseAction(printStream, scanner);
        assertEquals(false, curr);

        //Ввод Англичских букв
        when(scanner.nextLine()).thenReturn("C");
        curr = Chosen.chooseAction(printStream, scanner);
        assertEquals(true, curr);

        when(scanner.nextLine()).thenReturn("c");
        curr = Chosen.chooseAction(printStream, scanner);
        assertEquals(true, curr);

        //Ввод Русских букв
        when(scanner.nextLine()).thenReturn("С");
        curr = Chosen.chooseAction(printStream, scanner);
        assertEquals(true, curr);

        when(scanner.nextLine()).thenReturn("с");
        curr = Chosen.chooseAction(printStream, scanner);
        assertEquals(true, curr);
    }

    @Test
    public void chooseActionInvalid() {

        //Не тот символ
        when(scanner.nextLine()).thenReturn("k", "с");
        curr = Chosen.chooseAction(printStream, scanner);
        assertEquals(true, curr);
        verify(printStream, times(1)).println(Config.MESSAGE);

        //Не тот спецеальный символ
        when(scanner.nextLine()).thenReturn("#", "с");
        curr = Chosen.chooseAction(printStream, scanner);
        assertEquals(true, curr);
        verify(printStream, times(2)).println(Config.MESSAGE);

        //Пробел
        when(scanner.nextLine()).thenReturn(" ", "с");
        curr = Chosen.chooseAction(printStream, scanner);
        assertEquals(true, curr);
        verify(printStream, times(3)).println(Config.MESSAGE);

        //Пустота
        when(scanner.nextLine()).thenReturn("", "с");
        curr = Chosen.chooseAction(printStream, scanner);
        assertEquals(true, curr);
        verify(printStream, times(4)).println(Config.MESSAGE);
    }
}
