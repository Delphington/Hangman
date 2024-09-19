package backend.academy;

import java.util.NoSuchElementException;

public final class CheckData {
    private CheckData() {
    }

    public static boolean checkChar(String s) {
        return s.length() == 1 && Character.isLetter(s.charAt(0));
    }

    public static String checkString(String s) {
        if (s == null) {
            throw new NoSuchElementException("String is NULL");
        }
        return s.trim().toLowerCase();
    }
}
