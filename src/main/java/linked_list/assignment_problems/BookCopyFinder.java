// Problem no. 3
public class BookCopyFinder {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static String find(Node head, String id) {
        Node current = head;
        int position = 1;
        int firstPosition = -1;
        int copies = 0;

        while (current != null) {
            if (current.data.equals(id)) {
                copies++;
                if (firstPosition == -1) {
                    firstPosition = position;
                }
            }
            position++;
            current = current.next;
        }

        if (copies == 0) {
            return id + " not found";
        } else {
            return id + " first at position " + firstPosition + ", copies: " + copies;
        }
    }

    public static Node build(String[] ids) {
        if (ids == null || ids.length == 0) return null;
        Node head = new Node(ids[0]);
        Node current = head;
        for (int i = 1; i < ids.length; i++) {
            current.next = new Node(ids[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        String[] ids = {"B12", "B07", "B30", "B07", "B45", "B07"};
        Node trolley = build(ids);

        System.out.println(find(trolley, "B07")); // B07 first at position 2, copies: 3
        System.out.println(find(trolley, "B99")); // B99 not found
    }
}
