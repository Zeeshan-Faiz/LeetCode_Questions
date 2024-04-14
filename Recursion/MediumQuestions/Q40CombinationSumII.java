package Recursion.MediumQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique
combinations in candidates where the candidate numbers sum to target. Each number in candidates 
may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Example 1:

*/

public class Q40CombinationSumII {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    public void helper(int[] nums, int target, int index, List<Integer> list) {
        
        if (target == 0) {
            List<Integer> temp = new ArrayList<>();
            for (int j : list) {
                temp.add(j);
            }
            result.add(temp);
            return;
        }

        //Base case: if index exceeds array bounds or target is less than current element
        if (index == nums.length || target < nums[index]) {
            return;
        }

        int temp = nums[index];
        list.add(nums[index]);
        helper(nums, target - nums[index], index + 1, list);
        list.remove(list.size() - 1); //Backtrack: remove last element

        int i = 1;
        while (index + i < nums.length && nums[index + i] == temp) {
            i++; // Skip duplicates
        }
        helper(nums, target, index + i, list); // Recur without choosing current element
        return;
    }
}