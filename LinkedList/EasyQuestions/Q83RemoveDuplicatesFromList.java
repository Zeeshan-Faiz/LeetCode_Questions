package LinkedList.EasyQuestions;

/*
Given the head of a sorted linked list, delete all duplicates such that each element 
appears only once. Return the linked list sorted as well.

Example 1:
Input: head = [1,1,2,3,3]
Output: [1,2,3]
*/

public class Q83RemoveDuplicatesFromList {
    
    static ListNode deleteDuplicates(ListNode head) {
        
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } 
            else {
                current = current.next;
            }
        }
        return head;
    }
}