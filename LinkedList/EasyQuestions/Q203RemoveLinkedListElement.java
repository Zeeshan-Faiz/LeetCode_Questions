package LinkedList.EasyQuestions;

/*
Given the head of a linked list and an integer val, remove all the nodes of the linked 
list that has Node.val == val, and return the new head.

Example 1:
Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
*/

public class Q203RemoveLinkedListElement {
    
    static ListNode removeElements(ListNode head, int val) {
        
        ListNode temp = new ListNode(0);//dummy node
        ListNode curr = temp;
        temp.next = head;//dummy node added ahead of head of the given list
        while(curr.next != null ){
            if(curr.next.val == val) 
                curr.next = curr.next.next;//found value then skip it
            else 
                curr = curr.next;
        }
        return temp.next;//return the updated list head
    }
}