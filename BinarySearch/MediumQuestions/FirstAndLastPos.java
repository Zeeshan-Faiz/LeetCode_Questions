package BinarySearch.MediumQuestions;

import java.util.Arrays;

/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending 
position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]
*/

public class FirstAndLastPos{

    static int[] searchRange(int[] nums, int target) {
        
        int[] res = {-1,-1};
        if(nums == null)
            return res;
        
        int low = 0, high = nums.length-1, mid = 0;
        while(low < high){

            mid = low + (high-low)/2;
            if(nums[mid] ==  target){
                
                if(nums[mid - 1] == target){
                    low = 0;
                    high = mid;
                    res[1] = mid;
                }
                else if(mid + 1 < nums.length && nums[mid + 1] == target){
                    low = mid + 1;
                    high = nums.length;
                    nums[0] = mid;
                }
            }
            else if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));

    }
    
}