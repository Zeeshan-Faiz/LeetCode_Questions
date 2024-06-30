package DynamicProgramming.MediumQuestions;

import java.util.Arrays;

/*
Given an integer array nums, return the number of longest increasing subsequences.
Notice that the sequence has to be strictly increasing.

Example 1:
Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].

Example 2:
Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.
*/

public class Q673NumberOfLongestSubsequence {
    
    public int findNumberOfLIS(int[] nums) {
         int number = 0;
        int[] lis = new int[nums.length + 1];
        int[] len = new int[nums.length];
        int[] dp = new int[nums.length];

        lis[0] = Integer.MIN_VALUE;
        for (int i = 1; i < lis.length; ++i) {
            lis[i] = Integer.MAX_VALUE;
        }
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            
            int pos = Arrays.binarySearch(lis, nums[i]);
            if (pos < 0) {
                pos = -(pos + 1);
                lis[pos] = nums[i];
                max = Math.max(max, pos);   
            }

            len[i] = pos;

            for(int j = 0; j < i; ++j)
            {
                if(len[j] == pos - 1 && nums[j] < nums[i])
                {
                    dp[i] += dp[j];
                }
            }
            dp[i] = Math.max(dp[i], 1);
        }
        int ans = 0;
        for(int i = 0; i < len.length; ++i)
        {
            if(len[i] == max)
            {
                ans += dp[i];
            }
        }
        return ans; 
    }
}