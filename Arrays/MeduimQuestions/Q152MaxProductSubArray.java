package Arrays.MeduimQuestions;

/*
Given an integer array nums, find a subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

public class Q152MaxProductSubArray {

    public int maxProduct(int[] nums) {
        
        int maxi = Integer.MIN_VALUE;
        int prod = 1;

        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            maxi = Math.max(prod, maxi);
            if (prod == 0)
                prod = 1;
        }

        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prod *= nums[i];
            maxi = Math.max(prod, maxi);
            if (prod == 0)
                prod = 1;
        }
        return maxi;
    }
}