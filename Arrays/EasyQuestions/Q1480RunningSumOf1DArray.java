package Arrays.EasyQuestions;

import java.util.Arrays;

/*
Difficulty = Easy
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.

Example 1:

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

Example 2:

Input: nums = [1,1,1,1,1]
Output: [1,2,3,4,5]
Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].

Example 3:

Input: nums = [3,1,2,10,1]
Output: [3,4,6,16,17]

*/

public class Q1480RunningSumOf1DArray {

    static int[] runningSum(int[] nums) {

        int [] temp = new int[nums.length];
        
        for(int i = 0; i < temp.length; i++){
            temp[i] = nums[i];
        }
 
        for(int i = 0; i <temp.length; i++){

            int sum = 0, k = 0;
            while(k <= i){
                sum = sum + temp[k];
                k++;
            }
            nums[i] = sum;
        }
        return nums;
        
    }
    
    public static void main(String[] args) {
        
        int[] ar = {1,2,3,4};

        System.out.println(Arrays.toString(runningSum(ar)));
    }


}
