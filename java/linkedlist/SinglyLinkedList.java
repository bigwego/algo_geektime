package linkedlist;

public class SinglyLinkedList {

    private Node head = null;

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Node[] data = new Node[]{ new Node(1, null), new Node(2, null), new Node(2, null), new Node(2, null), new Node(1, null) };
        for (Node node : data) {
            list.insert2Tail(node);
        }
        list.printAll();
        System.out.println(list.isPalindrome());
    }

    public Node findByValue(int val) {
        Node p = head;
        while (p != null && p.data != val) {
            p = p.next;
        }
        return p;
    }

    public Node findByIndex(int idx) {
        Node p = head;
        int pos = 0;
        while (p != null && pos < idx) {
            p = p.next;
            pos++;
        }
        return p;
    }

    public void insert2Head(int val) {
        //Node newHead = new Node(val, head);
        //head = newHead;
        Node newNode = new Node(val, null);
        insert2Head(newNode);
    }

    private void insert2Head(Node newNode) {

        // if empty linked list
        if (head == null) {
            head = newNode;
        }
        // if not empty linked list
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    private void insert2Tail(int val) {
        Node newNode = new Node(val, null);
        insert2Tail(newNode);
    }

    private void insert2Tail(Node newNode) {
        // if empty linked list
        if (head == null) {
            head = newNode;
        }
        // if not empty linked list
        else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = newNode;
        }
    }

    public void insertAfter(Node p, int val) {
        Node newNode = new Node(val, null);
        insertAfter(p, newNode);
    }

    private void insertAfter(Node p, Node newNode) {
        findNode(p);
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, int val) {
        Node newNode = new Node(val, null);
        insertBefore(p, newNode);
    }

    private void insertBefore(Node p, Node newNode) {
        findNode(p);
        if (head == p) {
            insert2Head(newNode);
            return;
        }
        Node curr = head;
        while (curr != null && curr.next != p) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.next = p;
    }

    public void deleteByNode(Node p) {
        if (head == null || p == null) {
            return;
        }
        Node curr = head;
        while (curr != null && curr.next != p) {
            curr = curr.next;
        }
        if (curr == null) {
            return;
        }
        curr.next = p.next;
        p.next = null;
    }

    private boolean isPalindrome() {
        // if empty linked list
        if (head == null) {
            System.out.println("empty linked list");
            return false;
        }

        // if one-element linked list
        if (head.next == null) {
            System.out.println("one-element linked list");
            return true;
        }

        Node fast = head;
        Node slow = head;

        // find the middle node
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Node leftHead = null;
        Node rightHead = slow.next;
        // total of nodes is odd
        if (fast.next == null) {
            leftHead = inverseWithoutDummyHead(slow).next;
        }
        // total of nodes is even
        else {
            leftHead = inverseWithoutDummyHead(slow);
        }
        return isSame(leftHead, rightHead);
    }

    private boolean isSame(Node l, Node r) {
        while (l != null && r != null) {
            if (l.data != r.data) {
                break;
            } else {
                l = l.next;
                r = r.next;
            }
        }
        return l == null && r == null;
    }

    private Node inverseWithoutDummyHead(Node p) {
        Node prev = null;
        Node next = null;
        Node curr = head;
        while (curr != p) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr.next = prev;
        return curr;
    }

    private void deleteByValue(int val) {
        while (head != null && head.data == val) {
            head = head.next;
        }
        if (head == null) {
            return;
        }
        Node curr = head;
        while (curr != null) {
            if (curr.next != null && curr.next.data == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }

    private void printAll() {
        printNodeFrom(head);
    }

    private void printNodeFrom(Node p) {
        if (p == null) {
            System.out.println("list is empty");
            return;
        }
        System.out.print(p.data);
        Node curr = p.next;
        while (curr != null) {
            System.out.print(" -> " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }

    private void findNode(Node p) {
        Node curr = head;
        while (curr != null && curr != p) {
            curr = curr.next;
        }
        if (curr == null) {
            throw new IllegalArgumentException("no such node found in list");
        }
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