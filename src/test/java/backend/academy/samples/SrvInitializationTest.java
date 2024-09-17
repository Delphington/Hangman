package backend.academy.samples;

import backend.academy.Config;
import backend.academy.SrvInitialization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class SrvInitializationTest {

    private PrintStream printStream;
    private BufferedReader bufferedReader;

    @BeforeEach
    void setUp() {
        printStream = Mockito.mock(PrintStream.class);
    }


    @Test
    void testGetInfoFileNotFound() throws Exception {
        // Создаем мок для PrintStream
        PrintStream mockPrintStream = Mockito.mock(PrintStream.class);

        // Путь к несуществующему файлу
        String nonExistentFilePath = "src/main/resources/non_existent_file.txt";

        // Здесь вам нужно будет изменить метод getInfo, чтобы он принимал путь к файлу как параметр
        Map<String, String> result = SrvInitialization.getInfo( 1, 1, mockPrintStream);

        // Проверяем, что результат пустой, так как файл не найден
        assertEquals(new HashMap<>(), result);

        // Проверяем, что сообщение об ошибке было выведено
        Mockito.verify(mockPrintStream).println(Mockito.anyString());
    }
    /*

    @Test
    void testGetInfoSuccess() throws Exception {
        String input = "[1:1]\nword1:hint1\nword2:hint2\n[1:2]\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        // Используем Mockito для имитации FileInputStream
        try (MockedStatic<FileInputStream> mockedStatic = mockStatic(FileInputStream.class)) {
            mockedStatic.when(() -> new FileInputStream(Config.FILE_PATH_OF_WORD)).thenReturn(bufferedReader);

            Map<String, String> result = SrvInitialization.getInfo(1, 1, printStream);
            assertNotNull(result);
            assertEquals(2, result.size());
            assertEquals("hint1", result.get("word1"));
            assertEquals("hint2", result.get("word2"));
        }
    }

    @Test
    void testGetInfoCategoryNotFound() throws Exception {
        String input = "[2:1]\nword1:hint1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        try (MockedStatic<FileInputStream> mockedStatic = mockStatic(FileInputStream.class)) {
            mockedStatic.when(() -> new FileInputStream(Config.FILE_PATH_OF_WORD)).thenReturn(bufferedReader);

            Map<String, String> result = SrvInitialization.getInfo(1, 1, printStream);
            assertNull(result);
            verify(printStream, never()).println(any(String.class)); // Убедитесь, что не было сообщений об ошибках
        }
    }


    @Test
    void testGetInfoIOException() throws Exception {
        try (MockedStatic<FileInputStream> mockedStatic = mockStatic(FileInputStream.class)) {
            mockedStatic.when(() -> new FileInputStream(Config.FILE_PATH_OF_WORD)).thenThrow(new IOException("IO exception"));

            SrvInitialization.getInfo(1, 1, printStream);
            verify(printStream).println("IO exception");
        }
    }*/
}
