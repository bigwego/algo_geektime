public class Solution {

    private static Node inverse(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node curr = head;
        Node prev = null;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static boolean isCircular(Node head) {
        if (head == null) {
            return false;
        }

        Node fast = head.next;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    private static Node deleteKth(Node head, int k) {
        Node curr = head;
        int cnt = 1;
        while (curr != null && cnt < k) {
            curr = curr.next;
            cnt++;
        }
        if (curr == null) {
            System.out.println("no such node");
            return null;
        }
        Node dummy = new Node(0, null);
        Node prev = dummy;
        prev.next = head;
        Node toBeDeleted = head;
        while (curr.next != null) {
            curr = curr.next;
            prev = toBeDeleted;
            toBeDeleted = toBeDeleted.next;
        }
        prev.next = toBeDeleted.next;
        toBeDeleted = null;
        return dummy.next;
    }

    private static void print(Node node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node = new Node(1, null);
        Node prev = node;
        for (int i = 2; i <= 9; i++) {
            Node newNode = new Node(i, null);
            prev.next = newNode;
            prev = newNode;
        }
        print(node);
        node = deleteKth(node, 11);
        print(node);
    }

    static class Node {
        private final int val;

        private Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}