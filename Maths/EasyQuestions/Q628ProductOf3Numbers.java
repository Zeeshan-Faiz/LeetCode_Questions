package Maths.EasyQuestions;

import java.util.Arrays;

public class Q628ProductOf3Numbers {

    /*
    Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

    Example 1:
    Input: nums = [1,2,3]
    Output: 6

    Example 2:
    Input: nums = [1,2,3,4]
    Output: 24

    Example 3:
    Input: nums = [-1,-2,-3]
    */

    //Approach 1 : Sort the array and find the largest product between 3 numbers
    static int maximumProduct(int[] nums) {

        Arrays.sort(nums);
        int case1 = nums[0] * nums[1] * nums[nums.length - 1];
        int case2 = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];

        int maxProduct = Integer.max(case1, case2);
        return maxProduct;
    }

    //Approach 2 : Find the 3 maximum numbers and 2 minimum numbers take product for each case and return the
    //maximumn between the two
    static int maximumProduct2(int[] nums) {
        
        // Initialize Maximum, second maximum and third maximum element
        int maxA=Integer.MIN_VALUE, maxB=Integer.MIN_VALUE, maxC=Integer.MIN_VALUE;

        // Initialize Minimum and second minimum element
        int minA=Integer.MAX_VALUE, minB=Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++)
        {
            // Update Maximum, second maximum and third maximum element
            if(nums[i] > maxA)
            {
                maxC = maxB;
                maxB = maxA;
                maxA = nums[i];
            }

            // Update second maximum and third maximum element
            else if(nums[i] > maxB)
            {
                maxC = maxB;
                maxB = nums[i];
            }

            // Update third maximum element
            else if(nums[i] > maxC)
                maxC = nums[i];

            // Update Minimum and second minimum element
            if(nums[i] < minA)
            {
                minB = minA;
                minA = nums[i];
            }

            // Update second minimum element
            else if(nums[i] < minB)
                minB = nums[i];
        }
        return Math.max(maxA * maxB * maxC, minA * minB * maxA);
    }

    public static void main(String[] args) {
        
        //System.out.println(maximumProduct(new int[] {1,2,3,4,5}));
        System.out.println(maximumProduct2(new int[] {1,2,3,4,5}));
    }
}