package Arrays.EasyQuestions;

/*
Difficulty = Easy
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, 
return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
*/

public class SearchInsertPosition {
    
    static int searchInsert(int[] nums, int target) {
    
        int low = 0, high = nums.length-1, mid = 0;
        while(low <= high){

            mid = (low+high)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public static void main(String[] args) {
        
        int[] ar = {1,3,5,6};
        int target = 4;

        System.out.println(searchInsert(ar, target));
    }
}
