// Problem no. 3
import java.util.Arrays;

public class LibraryBookShelf {
    public static void shelf(int[] books) {
        int n = books.length;

        for (int i = 1; i < n; i++) {
            int currentBook = books[i];
            int j = i - 1;

            while (j >= 0 && books[j] > currentBook) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = currentBook;

            System.out.println("After placing " + currentBook + ": " + Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        int[] books = {30, 10, 40, 20};
        shelf(books);
    }
}
