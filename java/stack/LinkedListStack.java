package stack;

public class LinkedListStack {

    private Node top;

    public void push(int val) {
        if (isEmpty()) {
            top = new Node(val, null);
        } else {
            top = new Node(val, top.next);
        }
    }

    public int poll() {
        if (top == null) {
            return -1;
        }
        Node retNode = top;
        top = top.next;
        return retNode.data;
    }

    private boolean isEmpty() {
        return top == null;
    }

    class Node {

        private final int data;

        private final Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
