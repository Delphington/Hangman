package backend.academy;

public class CheckDate {
    private CheckDate() {
    }

    public static boolean checkChar(String s) {
        if (s.length() == 1 && Character.isLetter(s.charAt(0))) {
            return true;
        }
        return false;
    }

}
