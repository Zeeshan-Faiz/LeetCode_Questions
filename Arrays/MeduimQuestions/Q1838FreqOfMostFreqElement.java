package Arrays.MeduimQuestions;

import java.util.Arrays;

/*
The frequency of an element is the number of times it occurs in an array.
You are given an integer array nums and an integer k. In one operation, you can choose an index 
of nums and increment the element at that index by 1.
Return the maximum possible frequency of an element after performing at most k operations.

Example 1:
Input: nums = [1,2,4], k = 5
Output: 3
Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
4 has a frequency of 3.

Example 2:
Input: nums = [1,4,8,13], k = 5
Output: 2
Explanation: There are multiple optimal solutions:
- Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
- Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
- Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
*/

public class Q1838FreqOfMostFreqElement {

    public int maxFrequency(int[] nums, int k) {
        
        Arrays.sort(nums);
        int left = 0, right = 0;
        int n = nums.length;
        long sum = 0; // Using long to avoid overflow

        while (right < n) 
        {
            sum = sum + nums[right];

            // Check if the current window can be made into an array with all elements as nums[right]
            long requiredSum = (long) nums[right] * (right - left + 1);
            long diff = requiredSum - sum;

            if (diff > k) {
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return right - left;
    }
}