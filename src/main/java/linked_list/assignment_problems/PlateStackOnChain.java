// Problem no. 5
public class PlateStackOnChain {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;
    private int size;

    public PlateStackOnChain() {
        this.top = null;
        this.size = 0;
    }

    public void push(String plate) {
        Node newNode = new Node(plate);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.printf("push %s -> top %s, size %d%n", plate, top.data, size);
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("pop -> stack is empty");
            return null;
        }
        String data = top.data;
        top = top.next;
        size--;
        System.out.printf("pop -> %s, size %d%n", data, size);
        return data;
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("peek -> stack is empty");
            return null;
        }
        System.out.printf("peek -> %s%n", top.data);
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        PlateStackOnChain stack = new PlateStackOnChain();
        stack.push("P1");
        stack.push("P2");
        stack.peek();
        stack.pop();
        stack.push("P3");
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("isEmpty -> " + stack.isEmpty());
    }
}
