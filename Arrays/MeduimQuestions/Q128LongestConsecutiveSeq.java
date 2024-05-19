package Arrays.MeduimQuestions;

import java.util.Arrays;

/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements 
sequence. You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
*/

public class Q128LongestConsecutiveSeq {

    public int longestConsecutive(int[] nums) {
        
        int n = nums.length;
        if (n == 0)
            return 0;
        
        Arrays.sort(nums);
        int maxsofar = 1;
        int count = 0;
        int lastsmaller = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) 
        {
            if (nums[i] - 1 == lastsmaller)
                count++;
            else if (nums[i] != lastsmaller)
                count = 1;

            lastsmaller = nums[i];
            maxsofar = Math.max(count, maxsofar);
        }
        return maxsofar;
    }
}