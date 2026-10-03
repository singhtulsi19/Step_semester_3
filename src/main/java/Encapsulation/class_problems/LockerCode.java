public class LockerCode {
    private String code;
    private final int lockerNumber;

    public LockerCode(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (code.equals(currentCode)) {
            code = newCode;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LockerCode locker = new LockerCode(101, "1234");
        System.out.println(locker.changeCode("1234", "5678"));
        System.out.println(locker.changeCode("0000", "9999"));
    }
}
