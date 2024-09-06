package backend.academy.samples;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import backend.academy.DrawingGallow;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * AssertJ is a Java library that provides a rich set of assertions
 * and truly helpful error messages and improves test code readability.
 * <p>
 * <a href="https://assertj.github.io/doc/">Library documentation</a>
 * <p>
 * <a href="https://github.com/assertj/assertj-examples/tree/main/assertions-examples/src/test/java/org/assertj/examples">More examples</a>
 */

public class DrawingGallowTest {

    @Test
    public void increment() {
        DrawingGallow drawingGallow = new DrawingGallow();
        drawingGallow.increment();
        assertEquals(1, drawingGallow.getCountError());
    }

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        // Перенаправляем стандартный вывод в ByteArrayOutputStream
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        // Восстанавливаем стандартный вывод
        System.setOut(originalOut);
    }

    @Test
    public void printGallows() {
        // Здесь вызываем метод, который выводит что-то в консоль
        DrawingGallow drawingGallow = new DrawingGallow();

        //Проверка на вывод, если ошибок еще не было
        drawingGallow.printGallows(System.out);
        assertEquals("", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset(); //Очистка консоли

        //Одна ошибка
        drawingGallow.increment();
        drawingGallow.printGallows(System.out);
        assertEquals("_ _ _ _ _ _\n" +
            "|           |\n" +
            "|           0\n" +
            "|\n" +
            "|\n" +
            "|\n" +
            "|\n" +
            "|", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset(); //Очистка консоли

        //Две ошибка
        drawingGallow.increment();
        drawingGallow.printGallows(System.out);
        assertEquals("_ _ _ _ _ _\n" +
            "|           |\n" +
            "|           0\n" +
            "|          /\n" +
            "|\n" +
            "|\n" +
            "|\n" +
            "|", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        //Третья ошибка
        drawingGallow.increment();
        drawingGallow.printGallows(System.out);
        assertEquals("_ _ _ _ _ _\n" +
            "|           |\n" +
            "|           0\n" +
            "|          / \\\n" +
            "|\n" +
            "|\n" +
            "|\n" +
            "|", outputStreamCaptor.toString().trim());

        //Четвертая
        outputStreamCaptor.reset();
        drawingGallow.increment();
        drawingGallow.printGallows(System.out);
        assertEquals("_ _ _ _ _ _\n" +
            "|           |\n" +
            "|           0\n" +
            "|          /|\\\n" +
            "|\n" +
            "|\n" +
            "|\n" +
            "|", outputStreamCaptor.toString().trim());

        //Пятая
        outputStreamCaptor.reset();
        drawingGallow.increment();
        drawingGallow.printGallows(System.out);
        assertEquals("_ _ _ _ _ _\n" +
            "|           |\n" +
            "|           0\n" +
            "|          /|\\\n" +
            "|          /\n" +
            "|\n" +
            "|\n" +
            "|", outputStreamCaptor.toString().trim());

        //Шестая
        outputStreamCaptor.reset();
        drawingGallow.increment();
        drawingGallow.printGallows(System.out);
        assertEquals("_ _ _ _ _ _\n" +
            "|           |\n" +
            "|           0\n" +
            "|          /|\\\n" +
            "|          / \\\n" +
            "|\n" +
            "|\n" +
            "|", outputStreamCaptor.toString().trim());

        //Если будет больше попопыток, чем  запланировано
        outputStreamCaptor.reset();
        drawingGallow.increment();
        drawingGallow.printGallows(System.out);
        assertEquals("", outputStreamCaptor.toString().trim());
    }
};
