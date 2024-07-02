package DynamicProgramming.MediumQuestions;

/*
Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. 
After partitioning, each subarray has their values changed to become the maximum value of that 
subarray.
Return the largest sum of the given array after partitioning. Test cases are generated so that the 
answer fits in a 32-bit integer.

Example 1:
Input: arr = [1,15,7,9,2,5,10], k = 3
Output: 84
Explanation: arr becomes [15,15,15,9,10,10,10]

Example 2:
Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
Output: 83

Example 3:
Input: arr = [1], k = 1
Output: 1
*/

public class Q1043PartitionArrayForMaxSum {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[500];

        for (int max = dp[0] = arr[0], i = 1; i < k;) {
            if (arr[i] > max)
                max = arr[i];
            dp[i] = max * ++i;
        }

        for (int i = k; i < arr.length; i++)
            find(arr, k, i, dp);

        return dp[arr.length - 1];
    }
}