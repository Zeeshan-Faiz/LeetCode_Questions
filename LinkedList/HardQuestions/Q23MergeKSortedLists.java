package LinkedList.HardQuestions;

/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []
*/

public class Q23MergeKSortedLists {
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return helper(lists,0,lists.length-1);
    }

    public ListNode helper(ListNode[] lists, int start,int end) {
        if(start == end) return lists[start];
        if(start == end-1) return merge(lists[start],lists[end]);
        int mid = start + (end-start) / 2;
        ListNode left = helper(lists,start,mid);
        ListNode right = helper(lists,mid+1,end);
        return merge(left,right);
    }
}