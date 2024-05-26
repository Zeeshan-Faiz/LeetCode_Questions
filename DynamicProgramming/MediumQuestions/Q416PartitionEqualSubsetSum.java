package DynamicProgramming.MediumQuestions;

/*
Given an integer array nums, return true if you can partition the array into two subsets such 
that the sum of the elements in both subsets is equal or false otherwise.

Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
*/

public class Q416PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0)
            return false;

        int subSetSum = totalSum / 2;
        int n = nums.length;
        Boolean[][] memo = new Boolean[n + 1][subSetSum + 1];
        return helper(nums, n - 1, subSetSum, memo);
    }

    public boolean helper(int[] nums, int n, int subSetSum, Boolean[][] memo) {
       
        if (subSetSum == 0)
            return true;
        if (n == 0 || subSetSum < 0)
            return false;

        // check if subSetSum for given n is already computed and stored in memo
        if (memo[n][subSetSum] != null)
            return memo[n][subSetSum];

        boolean result = helper(nums, n - 1, subSetSum - nums[n - 1], memo) ||
                helper(nums, n - 1, subSetSum, memo);
        
        memo[n][subSetSum] = result;
        return result;
    }
}