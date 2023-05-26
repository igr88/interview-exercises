package dev.me.exercises;

import static dev.me.exercises.data.Node.printList;

import dev.me.exercises.data.Node;

public class MergeTwoSortedLinkedLists {
    public static void main(String[] args) {
        var headA = new Node(1);
        headA.next = new Node(3);
        headA.next.next = new Node(5);
        headA.next.next.next = new Node(7);

        var headB = new Node(2);
        headB.next = new Node(4);
        headB.next.next = new Node(6);
        headB.next.next.next = new Node(8);

        System.out.println("List headA");
        printList(headA);
        System.out.println("List headB");
        printList(headB);
        System.out.println("Merged list");
        printList(mergeLists(headA, headB));
    }

    private static Node mergeLists(Node headA, Node headB) {
        if (headA == null) {
            return headB;
        }

        if (headB == null) {
            return headA;
        }

        Node mergedList = null;

        if (headA.value <= headB.value) {
            mergedList = headA;
            mergedList.next = mergeLists(headA.next, headB);
        } else {
            mergedList = headB;
            mergedList.next = mergeLists(headA, headB.next);
        }

        return mergedList;
    }

}
