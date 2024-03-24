package LinkedList.EasyQuestions;

/*
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists
intersect. If the two linked lists have no intersection at all, return null.

Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes 
before the intersected node in A; There are 3 nodes before the intersected node in B.
- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 
3rd node in B) are different node references. In other words, they point to two different locations in memory, 
while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
*/

public class Q160IntersectionOfTwoLinkedList {
    
    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode ptrA = headA, ptrB = headB;
        while (ptrA != ptrB) { // loop until we found the first common node
            ptrA = ptrA == null ? headB : ptrA.next; // once we're done with A, move to B
            ptrB = ptrB == null ? headA : ptrB.next; // once we're done with B, move to A
        }
        return ptrA;
    }
}