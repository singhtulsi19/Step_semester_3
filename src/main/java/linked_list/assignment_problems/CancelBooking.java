// Problem no. 4
public class CancelBooking {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node removeFirst(Node head, String booking) {
        if (head == null) {
            System.out.println(booking + " not found");
            return null;
        }

        if (head.data.equals(booking)) {
            return head.next;
        }

        Node current = head;
        while (current.next != null && !current.next.data.equals(booking)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println(booking + " not found");
        }

        return head;
    }

    public static void printList(Node head) {
        Node current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }

    public static Node build(String[] items) {
        if (items == null || items.length == 0) return null;
        Node head = new Node(items[0]);
        Node current = head;
        for (int i = 1; i < items.length; i++) {
            current.next = new Node(items[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // Sample 1
        Node b1 = build(new String[]{"104", "101", "107", "101"});
        b1 = removeFirst(b1, "101");
        printList(b1);

        // Sample 2
        Node b2 = build(new String[]{"104", "101", "107"});
        b2 = removeFirst(b2, "104");
        printList(b2);

        // Sample 3
        Node b3 = build(new String[]{"104", "101"});
        b3 = removeFirst(b3, "200");
        printList(b3);
    }
}
