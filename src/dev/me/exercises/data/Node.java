package dev.me.exercises.data;

public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value + (head.next != null ? " -> " : ""));
            head = head.next;
        }

        System.out.println();
    }
}
