package StackandQueue.MediumQuestions;

import java.util.ArrayDeque;
import java.util.Deque;

/*
You are given an integer array nums. The range of a subarray of nums is the difference between the 
largest and smallest element in the subarray. Return the sum of all subarray ranges of nums.
A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0 
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.

Example 2:
Input: nums = [1,3,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[3], range = 3 - 3 = 0
[3], range = 3 - 3 = 0
[1,3], range = 3 - 1 = 2
[3,3], range = 3 - 3 = 0
[1,3,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
*/

public class Q2104SumOfSubarrayRanges {

    public long subArrayRanges(int[] nums) {
        
        long ans = 0;
        Deque<Integer> mono_stack = new ArrayDeque<>();
        for (int right = 0; right <= nums.length; right++) 
        {
            while (!mono_stack.isEmpty() && (right == nums.length || nums[right] <= nums[mono_stack.peek()])) {
                int mid = mono_stack.pop();
                int left = mono_stack.isEmpty() ? -1 : mono_stack.peek();
                ans -= (long) nums[mid] * (right - mid) * (mid - left);
            }
            mono_stack.push(right);
        }
        mono_stack.clear();
        for (int right = 0; right <= nums.length; right++) 
        {
            while (!mono_stack.isEmpty() && (right == nums.length || nums[right] >= nums[mono_stack.peek()])) {
                int mid = mono_stack.pop();
                int left = mono_stack.isEmpty() ? -1 : mono_stack.peek();
                ans += (long) nums[mid] * (right - mid) * (mid - left);
            }
            mono_stack.push(right);
        }
        return ans;
    }
}