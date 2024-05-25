package Arrays.EasyQuestions;

import java.util.PriorityQueue;

/*
Design a class to find the kth largest element in a stream. Note that it is the kth largest 
element in the sorted order, not the kth distinct element.
Implement KthLargest class:
    KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of 
    integers nums.
    int add(int val) Appends the integer val to the stream and returns the element representing 
    the kth largest element in the stream.

Example 1:
Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8
*/

public class Q703KthLargestElementInStream {

    final PriorityQueue<Integer> heap = new PriorityQueue<>();
    final int k;

    public Q703KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        for (int n : nums)
            add(n);
    }

    public int add(int val) {
        if (heap.size() < k)
            heap.offer(val); // for adding the values of the array
        else if (val > heap.peek()) {
            heap.poll(); // remove the top element
            heap.add(val); // add the new element
        }
        return heap.peek();
    }
}