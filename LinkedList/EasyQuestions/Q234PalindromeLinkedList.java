package LinkedList.EasyQuestions;

/*
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:
Input: head = [1,2,2,1]
Output: true
*/

public class Q234PalindromeLinkedList {
    
    static boolean isPalindrome(ListNode head) {
        
        //Approach : Find the middle node and reverse the 2nd half of the list and compare it with
        //the first half to find palindrome
        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode rereverseHead = headSecond;

        // compare both the halves
        while (head != null && headSecond != null) {
            if (head.val != headSecond.val) {
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(rereverseHead);

        return head == null || headSecond == null;
    }

    //finding the middle node
    static ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

}