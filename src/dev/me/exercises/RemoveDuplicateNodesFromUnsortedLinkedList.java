package dev.me.exercises;

import static dev.me.exercises.data.Node.printList;

import dev.me.exercises.data.Node;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNodesFromUnsortedLinkedList {

    public static void main(String[] args) {
        var head = new Node(10);
        head.next = new Node(15);
        head.next.next = new Node(10);
        head.next.next.next = new Node(33);

        printList(head);
        printList(removeDuplicate(head));
    }

    private static Node removeDuplicate(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Set<Integer> nodes = new HashSet<>();
        var current = head;
        Node uniqueList = current;
        nodes.add(current.value);

        while (current.next != null) {
            if (nodes.add(current.next.value)) {
                uniqueList.next = current.next;
            }
            current = current.next;
        }

        return uniqueList;
    }
}
