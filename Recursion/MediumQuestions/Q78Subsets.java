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
    
}
