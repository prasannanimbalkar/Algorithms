package org.example;


//        Divide the List: Split the linked list into two halves. This can be done by finding the middle of the list using the fast and slow pointer approach.
//        Recursively Sort: Recursively sort the two halves of the linked list.
//        Merge: Merge the two sorted halves together.
// Visualize___https://www.hackerearth.com/practice/algorithms/sorting/merge-sort/visualize/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class LinkedList_MergeSort {

    // Function to sort the linked list using merge sort
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle of the list
        ListNode middle = getMiddle(head);
        System.out.println( "Middle: " + middle.val);
        ListNode nextOfMiddle = middle.next;
        middle.next = null; // Split the list into two halves

        // Apply mergeSort on left and right lists
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(nextOfMiddle);

        // Merge the sorted halves
        return sortedMerge(left, right);
    }

    // Function to merge two linked lists, tail recursively
    private ListNode sortedMerge(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;

        if (a.val <= b.val) {
            a.next = sortedMerge(a.next, b);
            return a;
        } else {
            b.next = sortedMerge(a, b.next);
            return b;
        }
    }

    // Utility function to get the middle of the linked list
    private ListNode getMiddle(ListNode head) {
        if (head == null) return head;

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        LinkedList_MergeSort list = new LinkedList_MergeSort();
        ListNode head = new ListNode(10);
        head.next = new ListNode(30);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(20);
        head.next.next.next.next.next = new ListNode(55);
        head.next.next.next.next.next.next = new ListNode(14);
        head.next.next.next.next.next.next.next = new ListNode(23);
        head.next.next.next.next.next.next.next.next = new ListNode(25);

        ListNode sortedList = list.mergeSort(head);
        printList(sortedList);
    }

    // Function to print the linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}



