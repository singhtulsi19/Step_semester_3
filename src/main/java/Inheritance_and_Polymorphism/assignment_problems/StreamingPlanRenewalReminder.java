import java.time.LocalDate;
import java.util.Scanner;

public class StreamingPlanRenewalReminder {
    static abstract class Plan {
        String name;
        LocalDate startDate;

        Plan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        abstract int validityDays();

        LocalDate renewalDate() {
            return startDate.plusDays(validityDays());
        }
    }

    static class BasicPlan extends Plan {
        BasicPlan(String name, LocalDate date) { super(name, date); }
        int validityDays() { return 30; }
    }

    static class StandardPlan extends Plan {
        StandardPlan(String name, LocalDate date) { super(name, date); }
        int validityDays() { return 90; }
    }

    static class PremiumPlan extends Plan {
        PremiumPlan(String name, LocalDate date) { super(name, date); }
        int validityDays() { return 365; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());
            Plan plan;

            if (type.equals("BASIC")) {
                plan = new BasicPlan(name, date);
            } else if (type.equals("STANDARD")) {
                plan = new StandardPlan(name, date);
            } else {
                plan = new PremiumPlan(name, date);
            }

            System.out.println(plan.name + ": " + plan.renewalDate());
        }
    }
}
