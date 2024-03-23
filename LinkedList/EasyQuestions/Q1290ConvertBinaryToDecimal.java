package LinkedList.EasyQuestions;

/*
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked 
list holds the binary representation of a number.
Return the decimal value of the number in the linked list. The most significant bit is at the head of the linked list.

Example 1:
Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10
*/

public class Q1290ConvertBinaryToDecimal {
    
    static int getDecimalValue(ListNode head) {
        
        int result = 0;
        while(head!=null){
            result=result * 2 + head.val;
            head=head.next;
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}