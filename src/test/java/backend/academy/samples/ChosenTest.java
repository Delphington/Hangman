package backend.academy.samples;

import backend.academy.Chosen;
import backend.academy.Config;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ChosenTest {

    private Scanner scanner;
    private PrintStream printStream;
    private Random random;
    private int category;

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
        random = mock(Random.class);
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
        when(scanner.nextLine()).thenReturn("5", "1"); // Введем неверно, а потом верно
        int category = Chosen.chooseCategory(scanner, printStream, random);

        assertEquals(1, category); // Сравним верное значение
        verify(printStream, times(1)).println(Config.WARNING_MESSAGE); // Проверим предупреждение

        // Выход снизу
        when(scanner.nextLine()).thenReturn("0", "1"); // Введем неверно, а потом верно
        category = Chosen.chooseCategory(scanner, printStream, random);

        assertEquals(1, category); // Сравним верное значение
        verify(printStream, times(2)).println(Config.WARNING_MESSAGE); // Проверим предупреждение

        //Ввод спецеального символа
        when(scanner.nextLine()).thenReturn("№", "1"); // Введем неверно, а потом верно
        category = Chosen.chooseCategory(scanner, printStream, random);

        assertEquals(1, category); // Сравним верное значение
        verify(printStream, times(3)).println(Config.WARNING_MESSAGE); // Проверим предупреждение

        //Ввод пробела
        when(scanner.nextLine()).thenReturn(" ", "1"); // Введем неверно, а потом верно
        category = Chosen.chooseCategory(scanner, printStream, random);

        assertEquals(1, category); // Сравним верное значение
        verify(printStream, times(4)).println(Config.WARNING_MESSAGE); // Проверим предупреждение

        //Ввод строки
        when(scanner.nextLine()).thenReturn("abs", "1"); // Введем неверно, а потом верно
        category = Chosen.chooseCategory(scanner, printStream, random);

        assertEquals(1, category); // Сравним верное значение
        verify(printStream, times(5)).println(Config.WARNING_MESSAGE); //
        //
        //        //Ввод пустоты
        when(scanner.nextLine()).thenReturn(""); // Simulate empty user input
        when(random.nextInt(Config.RANDOM_CATEGORY_MAX)).thenReturn(1); // Simulate random category

        // Act
        int actualCategory = Chosen.chooseCategory(scanner, printStream, random);

        // Assert
        assertEquals(1 + Config.RANDOM_CATEGORY_MIN, actualCategory); // Проверяем, что возвращается случайная категория

    }

}
