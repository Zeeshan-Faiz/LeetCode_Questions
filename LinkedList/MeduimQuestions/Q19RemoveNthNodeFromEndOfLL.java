package LinkedList.MeduimQuestions;

/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1,2], n = 1
Output: [1]
*/

public class Q19RemoveNthNodeFromEndOfLL {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        //create a new node with val = 0 and pointing to head
        ListNode res = new ListNode(0, head);
        ListNode dummy = res;

        for (int i = 0; i < n; i++) {
            head = head.next;
        }

        while (head != null) {
            head = head.next;
            dummy = dummy.next;
        }

        dummy.next = dummy.next.next;

        return res.next;
    }
}