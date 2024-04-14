package Recursion.MediumQuestions;

import java.util.Arrays;

/*
Given an integer array nums and an integer k, return true if it is possible to divide this array 
into k non-empty subsets whose sums are all equal.

Example 1:
Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

Example 2:
Input: nums = [1,2,3,4], k = 3
Output: false
*/

public class Q698PartitionToKEqualSum {

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;
        for (int i : nums) {
            sum = sum + i;
        }

        // sum%k must equal to 0 if not just return false
        if (sum % k != 0 || nums.length < k)
            return false;

        Arrays.sort(nums);

        // our target is sum/k and we have to find this in nums, k times then it is valid
        return canPartitionKSubsets(nums, sum / k, nums.length - 1, new int[k]);

    }
}