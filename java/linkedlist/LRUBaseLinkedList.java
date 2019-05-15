package linkedlist;

import java.util.Scanner;

public class LRUBaseLinkedList<T> {

    private static final Integer DEFAULT_CAPACITY = 10;

    private final SNode<T> head;

    private Integer length;

    private Integer capacity;

    private LRUBaseLinkedList() {
        head = new SNode<>();
        capacity = DEFAULT_CAPACITY;
        length = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
        this();
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            list.add(scanner.nextInt());
            list.printAll();
        }
    }

    private void add(T data) {
        SNode preNode = findPreNode(data);

        // not exists in list
        if (preNode != null) {
            deleteAfter(preNode);
        }
        // no space to add a new node
        else if (length == capacity) {
            deleteAtEnd();
        }
        insertAtHead(data);
    }

    private SNode findPreNode(T data) {
        SNode curr = head;
        while (curr.next != null && curr.next.element != data) {
            curr = curr.next;
        }
        return curr.next == null ? null : curr;
    }

    private void deleteAtEnd() {
        if (head.next == null) {
            return;
        }
        SNode curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        length--;
    }

    private void insertAtHead(T data) {
        SNode tmp = head.next;
        head.next = new SNode(data, tmp);
        length++;
    }

    private void deleteAfter(SNode node) {
        if (node == null || node.next == null) {
            return;
        }
        SNode next = node.next;
        node.next = next.next;
        next = null;
        length--;
    }

    private void printAll() {
        printNodeFrom(head.next);
    }

    private void printNodeFrom(SNode p) {
        if (p == null) {
            System.out.println("list is empty");
            return;
        }
        System.out.print(p.element);
        SNode curr = p.next;
        while (curr != null) {
            System.out.print(" -> " + curr.element);
            curr = curr.next;
        }
        System.out.println();
    }

    class SNode<T> {

        private T element;

        private SNode next;

        public SNode(T element) {
            this(element, null);
        }

        SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        SNode() {
        }
    }
}
