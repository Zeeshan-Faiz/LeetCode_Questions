package Recursion.MediumQuestions;

import java.util.ArrayList;
import java.util.List;

public class Q78Subsets {

    /*
    Given an integer array nums of unique elements, return all possible
    subsets
    (the power set).

    The solution set must not contain duplicate subsets. Return the solution in any order.

    Example 1:
    Input: nums = [1,2,3]
    Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

    Example 2:
    Input: nums = [0]
    Output: [[],[0]]
    */

    static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>(); // initialize the answer list

        ArrayList<Integer> subset = new ArrayList<>(); // initialize the subset list

        helper(nums, 0, subset, ans); // call the recursive helper function with initial values

        return ans; // return the answer list
    }

    static void helper(int nums[], int i, ArrayList<Integer> subset, List<List<Integer>> ans){
        
        // base case: if the index i has reached the end of the array, add the current subset to the answer list and return
        if(i == nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }

        // add the current element to the subset and recursively call the helper function with the next index
        subset.add(nums[i]);
        helper(nums, i + 1, subset, ans);

        // remove the last element from the subset and recursively call the helper function with the next index
        subset.remove(subset.size()-1);
        helper(nums, i + 1, subset, ans);
    }
    
}
