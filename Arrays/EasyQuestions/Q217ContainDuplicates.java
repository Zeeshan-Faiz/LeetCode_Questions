package Arrays.EasyQuestions;

/*
Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
*/

public class Q217ContainDuplicates {
    
    public boolean containsDuplicate(int[] nums) {
        int length = nums.length;
        if (length == 1) return false;
        if (length == 2) return nums[0] == nums[1];
        
        for (int i = 0; i < nums.length-1; i++){
            for (int j = i + 1; j > 0; j--){
                int eleJ = nums[j];
                int elePrevJ = nums[j-1];
                if (eleJ == elePrevJ) {
                    return true;
                } else if (eleJ < elePrevJ) {
                    nums[j] = elePrevJ;
                    nums[j-1] = eleJ;
                } else {
                    break;
                }
            }
        }
        return false;
    }
}