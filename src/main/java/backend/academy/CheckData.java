package backend.academy;

public final class CheckData {
    private CheckData() {
    }

    public static boolean checkChar(String s) {
        return s.length() == 1 && Character.isLetter(s.charAt(0));
    }
}
