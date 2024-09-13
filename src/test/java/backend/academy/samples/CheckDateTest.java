package backend.academy.samples;

import backend.academy.CheckData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CheckDateTest {

    @Test
    public void testCheckCharWithSingleLetter() {
        assertTrue(CheckData.checkChar("a")); // маленькая буква
        assertTrue(CheckData.checkChar("Z")); // заглавная буква
    }

    @Test
    public void testCheckCharWithSingleLetterRu() {
        assertTrue(CheckData.checkChar("р")); // маленькая буква
        assertTrue(CheckData.checkChar("Р")); // заглавная буква
    }

    @Test
    public void testCheckCharWithNonLetter() {
        assertFalse(CheckData.checkChar("1")); // цифра
        assertFalse(CheckData.checkChar("@")); // специальный символ
        assertFalse(CheckData.checkChar("!")); // специальный символ
        assertFalse(CheckData.checkChar(" ")); // пробел
    }

    @Test
    public void testCheckCharWithMultipleCharacters() {
        assertFalse(CheckData.checkChar("ab")); // две буквы
        assertFalse(CheckData.checkChar("12")); // две цифры
        assertFalse(CheckData.checkChar("a1")); // буква и цифра
        assertFalse(CheckData.checkChar("a!")); // буква и специальный символ
    }

    @Test
    public void testCheckCharWithEmptyString() {
        assertFalse(CheckData.checkChar("")); // пустая строка
    }

}
