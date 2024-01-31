package Arrays.EasyQuestions;

import java.util.Arrays;

/*
Difficulty = Easy
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted
in non-decreasing order.
Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
*/

public class Q977SquaresOfSortedArray {

    static int[] sortedSquares(int[] nums) {
        
        /*
        Brute Force (Time Complexity = O(n Log n))
        for(int i = 0; i < nums.length; i++){          
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
        */

        //Optimized using two pointers.
        //Time Complexity and Space Complexity = O(n)

        int[] result = new int[nums.length];
        int left=0,right=nums.length-1;
        int pointers = nums.length-1;
        while(left <= right){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                result[pointers] = nums[left] * nums[left];
                left++;
            }
            else{
                result[pointers] = nums[right] * nums[right];
                right--;
            }
            pointers--;
        }
        return result;
    }

    public static void main(String[] args) {
        
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4,-1,0,3,10})));
    }
}
