// Problem no. 1
public class BusRouteStops {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node build(String[] stops) {
        if (stops == null || stops.length == 0) return null;
        Node head = new Node(stops[0]);
        Node current = head;
        for (int i = 1; i < stops.length; i++) {
            current.next = new Node(stops[i]);
            current = current.next;
        }
        return head;
    }

    public static void printRoute(Node head) {
        if (head == null) {
            System.out.println("null");
            System.out.println("Stops: 0");
            return;
        }

        Node current = head;
        int count = 0;
        String first = head.data;
        String last = head.data;

        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.data).append(" -> ");
            count++;
            last = current.data;
            current = current.next;
        }
        sb.append("null");

        System.out.println(sb.toString());
        System.out.printf("Stops: %d, First: %s, Last: %s%n", count, first, last);
    }

    public static void main(String[] args) {
        String[] stops1 = {"Tambaram", "Guindy", "TNagar", "Central"};
        Node head1 = build(stops1);
        printRoute(head1);

        String[] stops2 = {"Potheri"};
        Node head2 = build(stops2);
        printRoute(head2);
    }
}
