// Problem no. 1
import java.util.Scanner;

public class VowelAndConsonantCounter {
    public static void countVowelsAndConsonants(String word) {
        int vowels = 0;
        int consonants = 0;
        for (char ch : word.toCharArray()) {
            if (Character.isLetter(ch)) {
                char lower = Character.toLowerCase(ch);
                if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            String word = sc.next();
            countVowelsAndConsonants(word);
        } else {
            countVowelsAndConsonants("Programming");
        }
        sc.close();
    }
}
