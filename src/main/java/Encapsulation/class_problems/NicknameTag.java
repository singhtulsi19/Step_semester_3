public class NicknameTag {
    private final String firstName;
    private final String lastName;

    public NicknameTag(String fullName) {
        String[] parts = fullName.split(" ");
        firstName = parts[0];
        lastName = parts[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }

    public static void main(String[] args) {
        NicknameTag tag = new NicknameTag("Maria Gomez");
        System.out.println(tag.getNickname());
    }
}
