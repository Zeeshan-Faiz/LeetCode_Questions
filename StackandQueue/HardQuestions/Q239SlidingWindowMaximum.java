package StackandQueue.HardQuestions;

import java.util.ArrayDeque;

/*
You are given an array of integers nums, there is a sliding window of size k which is moving from 
the very left of the array to the very right. You can only see the k numbers in the window. 
Each time the sliding window moves right by one position. Return the max sliding window.

Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
*/

public class Q239SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int[] res = new int[n - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = k - 1; i >= 0; i--) 
        {
            if (deque.isEmpty())
                deque.addFirst(i);
            else {
                if (nums[i] > nums[deque.getLast()])
                    deque.addLast(i);
            }
        }
        
        res[0] = nums[deque.getLast()];
        for (int i = k; i < n; i++) 
        {
            if (deque.getLast() == i - k)
                deque.removeLast();
                
            int candidate = nums[i];
            while (!deque.isEmpty() && nums[deque.getFirst()] < candidate) {
                deque.removeFirst();
            }
            deque.addFirst(i);
            res[i - k + 1] = nums[deque.getLast()];
        }
        return res;
    }
}