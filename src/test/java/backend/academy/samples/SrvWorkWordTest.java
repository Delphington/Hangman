package backend.academy.samples;

import backend.academy.SrvWorkWord;
import backend.academy.info.Config;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class SrvWorkWordTest {

    private PrintStream originalPrintStream;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        originalPrintStream = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testInitializationFileNotFound() {
        //путь к неверному файла
        String invalidFilePath = "invalid/path/to/file.txt";
        Config.filePathOfWord = invalidFilePath;

        // Проверяем, что при вызове метода выбрасывается NullPointerException
        assertThrows(NullPointerException.class, () -> {
            SrvWorkWord.initialization(0, 0, originalPrintStream, new Random());
        });
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalPrintStream);
    }
}
