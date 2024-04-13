package Recursion.MediumQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Given an array nums of distinct integers, return all the possible permutations. 
You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]
*/

public class Q46Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        recurpermute(0, nums, ans);
        return ans;
    }

    public void recurpermute(int index, int[] nums, List<List<Integer>> ans) {
        
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            ans.add(list);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recurpermute(index + 1, nums, ans);
            swap(i, index, nums);
        }
    }

    public void swap(int index1, int index, int[] nums) {
        int temp = nums[index];
        nums[index] = nums[index1];
        nums[index1] = temp;
    }
}