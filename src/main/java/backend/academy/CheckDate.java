package backend.academy;

public class CheckDate {
    private CheckDate() {
    }

    public static boolean checkChar(String s) {
        return s.length() == 1 && Character.isLetter(s.charAt(0));
    }
}
