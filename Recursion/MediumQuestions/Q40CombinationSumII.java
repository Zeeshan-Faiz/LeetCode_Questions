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
        Arrays.sort(candidates); // Sort candidates array
        solve(candidates, target, 0, new ArrayList<>()); // Call recursive function
        return result;
    }
}