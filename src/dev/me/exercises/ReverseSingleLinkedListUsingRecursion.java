package dev.me.exercises;

import static dev.me.exercises.data.Node.printList;

import dev.me.exercises.data.Node;

public class ReverseSingleLinkedListUsingRecursion {
    public static void main(String[] args) {
        var head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        printList(head);
        printList(reverseList(head));
    }

    private static Node reverseList(Node head) {
        return reverseWithRecursion(head);
    }

    private static Node reverseWithRecursion(Node current) {
        if (current == null || current.next == null) {
            return current;
        }

        var reversed = reverseWithRecursion(current.next);
        current.next.next = current;
        current.next = null;
        return reversed;
    }
}
