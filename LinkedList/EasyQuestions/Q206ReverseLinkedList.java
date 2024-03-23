package LinkedList.EasyQuestions;

/*
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
*/

public class Q206ReverseLinkedList {
    
    static ListNode reverseList(ListNode head) {
        
        if (head == null) 
           return head;
       
       ListNode prev = null;
       ListNode present = head;
       ListNode next = present.next;

       while (present != null) {
           present.next = prev;//change the direction
           prev = present;
           present = next;
           if (next != null) {
               next = next.next;
           }
       }
       return prev;//after loop ends prev will be the new head from last
   }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}