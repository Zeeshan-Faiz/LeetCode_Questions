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

public class Q34FirstAndLastPos {

    static int[] searchRange(int[] nums, int target) {

        int ans[] = { -1, -1 };
        int start = search(nums, target, true);
        int end = search(nums, target, false);
        ans[0] = start;
        ans[1] = end;
        return ans;
    }

    static int search(int[] nums, int target, boolean findIndex) {
        
        int ans = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {

            int mid = low + (high - low) / 2;
            if (target > nums[mid]) 
                low = mid + 1;
            else if (target < nums[mid]) 
                high = mid - 1;
            else 
            {
                if (target == nums[mid]) {
                    ans = mid;
                    if (findIndex)
                        high = mid - 1;
                    else
                        low = mid + 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
    }
}