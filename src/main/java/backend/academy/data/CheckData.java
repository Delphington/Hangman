package backend.academy.data;

import backend.academy.info.StringConst;
import java.util.NoSuchElementException;

public final class CheckData implements StringConst {
    private CheckData() {
    }

    public static boolean checkChar(String s) {
        return s.length() == 1 && Character.isLetter(s.charAt(0));
    }

    public static String correctToString(String s) {
        if (s == null) {
            throw new NoSuchElementException(MESSAGE_STRING_NULL);
        }
        return s.trim().toLowerCase();
    }
}
