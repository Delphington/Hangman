//package backend.academy.samples;
//
//import backend.academy.Config;
//import backend.academy.SrvInitialization;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import java.io.*;
//import java.nio.charset.StandardCharsets;
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class SrvInitializationTest {
//
//    private PrintStream printStream;
//
//    @BeforeEach
//    void setUp() {
//        printStream = Mockito.mock(PrintStream.class);
//    }
//
//    @Test
//    void testGetInfoValidInput() throws IOException {
//        String content = "[1:1]\nword1:hint1\nword2:hint2\n[1:2]\n";
//        InputStream inputStream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
//        System.setIn(inputStream);
//
//        // Устанавливаем путь к файлу, который будет использоваться в тесте
//        Config.FILE_PATH_OF_WORD = "test.txt";
//        try (PrintWriter out = new PrintWriter(Config.FILE_PATH_OF_WORD)) {
//            out.print(content);
//            out.flush();
//        }
//
//        Map<String, String> result = SrvInitialization.getInfo(1, 1, printStream);
//
//        assertNotNull(result);
//        assertEquals(2, result.size());
//        assertEquals("hint1", result.get("word1"));
//        assertEquals("hint2", result.get("word2"));
//    }
//
//    @Test
//    void testGetInfoCategoryNotFound() {
//        Map<String, String> result = SrvInitialization.getInfo(99, 99, printStream);
//        assertNotNull(result);
//        assertTrue(result.isEmpty());
//    }
//}
