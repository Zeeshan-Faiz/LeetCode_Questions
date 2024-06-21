package DynamicProgramming.HardQuestions;

import java.util.Arrays;

/*
You are given an integer array nums of 2 * n integers. You need to partition nums into two arrays 
of length n to minimize the absolute difference of the sums of the arrays. To partition nums, put 
each element of nums into one of the two arrays.
Return the minimum possible absolute difference.

Example 1:
Input: nums = [3,9,7,3]
Output: 2
Explanation: One optimal partition is: [3,9] and [7,3].
The absolute difference between the sums of the arrays is abs((3 + 9) - (7 + 3)) = 2.

Example 2:
Input: nums = [-36,36]
Output: 72
Explanation: One optimal partition is: [-36] and [36].
The absolute difference between the sums of the arrays is abs((-36) - (36)) = 72.

Example 3:
Input: nums = [2,-1,0,4,-2,-9]
Output: 0
Explanation: One optimal partition is: [2,4,-9] and [-1,0,-2].
The absolute difference between the sums of the arrays is abs((2 + 4 + -9) - (-1 + 0 + -2)) = 0.
*/

public class Q2035PartitionArrayIntoTwoSubArrays {
    
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int[][] diff1 = generate(Arrays.copyOfRange(nums, 0, n / 2));
        int[][] diff2 = generate(Arrays.copyOfRange(nums, n / 2, n));

        int min = Integer.MAX_VALUE;
        for (int len = 0; len <= n / 2; len++) {
            int[] left = diff1[len];
            int[] right = diff2[len];

            int l = 0;
            int r = 0;

            while (l < left.length && r < left.length) {
                // arrays are already sorted so we move one pointer at a time to make the diff
                // closer to 0
                int diff = left[l] - right[r];
                min = Math.min(min, Math.abs(diff));
                if (diff < 0)
                    l++;
                else if (diff > 0)
                    r++;
                else
                    return 0;
            }
        }

        return min;
    }
}