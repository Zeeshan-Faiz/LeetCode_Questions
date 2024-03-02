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
        int case1 = nums[0]*nums[1]*nums[nums.length-1];
        int case2 = nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];

        int maxProduct = Integer.max(case1, case2);
        return maxProduct;
    }

    public static void main(String[] args) {
        
        System.out.println(maximumProduct(new int[] {1,2,3,4,5}));
    }
    
}