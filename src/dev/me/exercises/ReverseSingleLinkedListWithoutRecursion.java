package dev.me.exercises;

import static dev.me.exercises.data.Node.printList;

import dev.me.exercises.data.Node;
import java.util.Stack;

public class ReverseSingleLinkedListWithoutRecursion {

    public static void main(String[] args) {
        var root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);

        printList(root);
        System.out.println();
        printList(reverse(root));
    }

    public static Node reverse(Node head) {
        if (head == null) {
            return null;
        }

        var current = head;
        var stack = new Stack<Node>();

        stack.push(current);

        while (current.next != null) {
            stack.push(current.next);
            current = current.next;
        }

        head = stack.pop();
        current = head;

        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }

        current.next = null;

        return head;
    }
}
