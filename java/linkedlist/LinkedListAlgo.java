package linkedlist;

public class LinkedListAlgo {

    private static Node inverse(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node prev = null;
        Node next = null;
        Node curr = node;
        while (curr.next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr.next = prev;
        return curr;
    }

    public static boolean checkCircle(Node head) {
        if (head == null || head.next == null) {
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

    public static Node mergeSortedLists(Node la, Node lb) {
        Node dummy = new Node(0, null);
        Node tail = dummy;
        while (la != null && lb != null) {
            if (la.data < lb.data) {
                tail.next = la;
                la = la.next;
            } else {
                tail.next = lb;
                lb = lb.next;
            }
            tail = tail.next;
        }
        tail.next = la != null ? la : lb;
        return dummy.next;
    }

    private static Node deleteLastKth(Node head, int k) {
        int cnt = 1;
        Node curr = head;
        while (curr != null && cnt < k) {
            curr = curr.next;
            cnt++;
        }
        if (curr == null) {
            return curr;
        }
        Node dummy = new Node(0, null);
        dummy.next = head;
        Node pp = null;
        Node p = dummy;
        while (curr != null) {
            curr = curr.next;
            pp = p;
            p = p.next;
        }
        pp.next = p.next;
        p.next = null;
        Node ret = dummy.next;
        dummy.next = null;
        dummy = null;
        return ret;
    }

    private static void printAll(Node node) {
        Node curr = node;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
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
        LinkedListAlgo.printAll(node);
        //LinkedListAlgo.printAll(LinkedListAlgo.inverse(node));
        LinkedListAlgo.printAll(LinkedListAlgo.deleteLastKth(node, 2));
    }

    static class Node {

        private final int data;

        private Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}