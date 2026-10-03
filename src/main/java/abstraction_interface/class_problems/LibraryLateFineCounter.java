import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public abstract double getFine();
}

class BookItem extends LibraryItem {
    BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    public double getFine() {
        return daysLate * 2;
    }
}

class DVDItem extends LibraryItem {
    DVDItem(String title, int daysLate) {
        super(title, daysLate);
    }

    public double getFine() {
        double fine = daysLate * 5;
        return Math.min(fine, 50);
    }
}

class MagazineItem extends LibraryItem {
    MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    public double getFine() {
        return daysLate;
    }
}

public class LibraryLateFineCounter {
    public static LibraryItem createItem(String type, String title, int daysLate) {
        if (type.equals("BOOK")) {
            return new BookItem(title, daysLate);
        }
        if (type.equals("DVD")) {
            return new DVDItem(title, daysLate);
        }
        return new MagazineItem(title, daysLate);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();
            LibraryItem item = createItem(type, title, daysLate);
            double fine = item.getFine();
            System.out.printf("%s: %.2f%n", title, fine);
            total += fine;
        }

        System.out.printf("Total Fines: %.2f%n", total);
    }
}
