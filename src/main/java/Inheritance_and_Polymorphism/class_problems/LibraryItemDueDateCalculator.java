import java.time.LocalDate;
import java.util.Scanner;

public class LibraryItemDueDateCalculator {
    static abstract class LibraryItem {
        String title;
        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        LibraryItem(String title) {
            this.title = title;
        }

        abstract int getBorrowingDays();

        LocalDate getDueDate() {
            return currentDate.plusDays(getBorrowingDays());
        }
    }

    static class Book extends LibraryItem {
        Book(String title) { super(title); }
        int getBorrowingDays() { return 14; }
    }

    static class DVD extends LibraryItem {
        DVD(String title) { super(title); }
        int getBorrowingDays() { return 7; }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) { super(title); }
        int getBorrowingDays() { return 3; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1).trim();
            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item;
            if (type.equals("BOOK")) {
                item = new Book(title);
            } else if (type.equals("DVD")) {
                item = new DVD(title);
            } else {
                item = new Magazine(title);
            }

            System.out.println(item.title + ": " + item.getDueDate());
        }
    }
}
