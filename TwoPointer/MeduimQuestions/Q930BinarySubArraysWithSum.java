package TwoPointer.MeduimQuestions;

/*
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a 
sum goal.
A subarray is a contiguous part of the array.

Example 1:
Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]

Example 2:
Input: nums = [0,0,0,0,0], goal = 0
Output: 15
*/

public class Q930BinarySubArraysWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {

        int ans = atMostK(nums, goal) - atMostK(nums, goal - 1);
        return ans;
    }

    public static int atMostK(int[] nums, int goal) {

        int sum = 0;
        int end = 0;
        int count = 0;

        for (int start = 0; start < nums.length; start++) 
        {
            sum = sum + nums[start];
            while (end <= start && sum > goal) {
                sum = sum - nums[end];
                end++;
            }
            count = count + start - end + 1;
        }
        return count;
    }
}