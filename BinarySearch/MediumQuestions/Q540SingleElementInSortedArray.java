package BinarySearch.MediumQuestions;

/*
You are given a sorted array consisting of only integers where every element appears exactly twice, 
except for one element which appears exactly once. Return the single element that appears only once.
Your solution must run in O(log n) time and O(1) space.

Examplle 1:
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:
Input: nums = [3,3,7,7,10,11,11]
Output: 10
*/

public class Q540SingleElementInSortedArray {

    public int singleNonDuplicate(int[] nums) {

        int l = 0, r = nums.length - 1;

        while (l < r) {

            int mid = l + (r - l) / 2;
            if (mid % 2 == 1)
                mid--;

            if (nums[mid] != nums[mid + 1]) 
                r = mid;
            else 
                l = mid + 2;
        }
        return nums[l];
    }
}