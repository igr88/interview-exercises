package dev.me.exercises;

import static dev.me.exercises.data.Node.printList;

import dev.me.exercises.data.Node;

public class LengthOfLinkedList {

    public static void main(String[] args) {
        var head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        printList(head);
        System.out.println(findLengthWithRecursion(head));
        System.out.println(findLengthWithoutRecursion(head));
    }

    private static int findLengthWithoutRecursion(Node head) {
        var current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }

    private static int findLengthWithRecursion(Node head) {
        if (head == null) {
            return 0;
        }

        return 1 + findLengthWithRecursion(head.next);
    }


}
