public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        if (password.length() < 6) {
            return "Weak";
        }
        if (password.length() < 10) {
            return "Medium";
        }
        return "Strong";
    }

    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker("abcd");
        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println(pc.getStrength());
        System.out.println(pc2.getStrength());
    }
}
