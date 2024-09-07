package backend.academy.samples;

import backend.academy.CheckDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CheckDateTest {

    @Test
    public void testCheckCharWithSingleLetter() {
        assertTrue(CheckDate.checkChar("a")); // маленькая буква
        assertTrue(CheckDate.checkChar("Z")); // заглавная буква
    }

    @Test
    public void testCheckCharWithSingleLetterRu() {
        assertTrue(CheckDate.checkChar("р")); // маленькая буква
        assertTrue(CheckDate.checkChar("Р")); // заглавная буква
    }

    @Test
    public void testCheckCharWithNonLetter() {
        assertFalse(CheckDate.checkChar("1")); // цифра
        assertFalse(CheckDate.checkChar("@")); // специальный символ
        assertFalse(CheckDate.checkChar("!")); // специальный символ
        assertFalse(CheckDate.checkChar(" ")); // пробел
    }

    @Test
    public void testCheckCharWithMultipleCharacters() {
        assertFalse(CheckDate.checkChar("ab")); // две буквы
        assertFalse(CheckDate.checkChar("12")); // две цифры
        assertFalse(CheckDate.checkChar("a1")); // буква и цифра
        assertFalse(CheckDate.checkChar("a!")); // буква и специальный символ
    }

    @Test
    public void testCheckCharWithEmptyString() {
        assertFalse(CheckDate.checkChar("")); // пустая строка
    }

}
