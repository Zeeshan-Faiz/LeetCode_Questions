package DynamicProgramming.MediumQuestions;

/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1
*/

public class Q300LongestIncreasingSubSeq {
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = Integer.MIN_VALUE;

        int curLen = 0;
        for(int num : nums) {
            if(dp[curLen] < num) {
                curLen++;
                dp[curLen] = num;
            } else {
                int temp = curLen - 1;
                while(dp[temp] >= num) {
                    temp--;
                }
                dp[temp + 1] = num;
            }
        }
        return curLen;
    }
}