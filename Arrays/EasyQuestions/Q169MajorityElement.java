package Arrays.EasyQuestions;

import java.util.Arrays;

/*
Difficulty = Easy
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element 
always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3

Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2

*/

public class Q169MajorityElement {

    static int majorityElement(int[] nums) {

        /*
        Brute Force = O(n^2)
        for(int i = 0; i < nums.length; i++){
            int count = 1;
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] == nums[j])
                    count++;
            }
            if(count > nums.length/2)
                return nums[i];
        }
        return -1;
        */

        //Optimized = Boyer-Moore Voting Algorithm (Time Complexity = O(n))

        int maj = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){

            if(nums[i] == maj)
                count++;
            else
                count--;
            
            if(count == 0){
                maj = nums[i];
                count = 1;
            }
        }
        return maj;
    }

    public static void main(String[] args) {
        
        int[] ar = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(ar));
    }
    
}
