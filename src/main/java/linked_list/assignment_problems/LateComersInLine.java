// Problem no. 2
public class LateComersInLine {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node addFirst(Node head, String name) {
        Node newNode = new Node(name);
        newNode.next = head;
        return newNode;
    }

    public static Node addLast(Node head, String name) {
        Node newNode = new Node(name);
        if (head == null) {
            return newNode;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public static void printLine(Node head) {
        Node current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        // Sample 1
        Node line1 = new Node("Asha");
        line1.next = new Node("Ravi");

        line1 = addFirst(line1, "Neha");
        line1 = addLast(line1, "Kiran");
        line1 = addFirst(line1, "Mohan");
        printLine(line1);

        // Sample 2
        Node line2 = null;
        line2 = addLast(line2, "Pooja");
        line2 = addFirst(line2, "Arun");
        printLine(line2);
    }
}
