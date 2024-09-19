package backend.academy;

import java.util.NoSuchElementException;

public final class CheckData implements StringConst {
    private CheckData() {
    }

    public static boolean checkChar(String s) {
        return s.length() == 1 && Character.isLetter(s.charAt(0));
    }

    public static String checkString(String s) {
        if (s == null) {
            throw new NoSuchElementException(MESSAGE_STRING_NULL);
        }
        return s.trim().toLowerCase();
    }
}
