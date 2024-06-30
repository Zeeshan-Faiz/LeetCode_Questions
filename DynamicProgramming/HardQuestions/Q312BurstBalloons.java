package DynamicProgramming.HardQuestions;

/*
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it 
represented by an array nums. You are asked to burst all the balloons.
If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or 
i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
Return the maximum coins you can collect by bursting the balloons wisely.

Example 1:
Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167

Example 2:
Input: nums = [1,5]
Output: 10
*/

public class Q312BurstBalloons {

    public int maxCoins(int[] nums) {
        
        int n = nums.length;
        int[] arr = new int[n + 2];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        arr[0] = 1;
        arr[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                int mul = arr[i] * arr[j];
                int max = 0;
                for (int k = i + 1; k < j; k++) {
                    max = Math.max(max, mul * arr[k] + dp[i][k] + dp[k][j]);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][n + 1];
    }
}