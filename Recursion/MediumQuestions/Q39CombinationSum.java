package Recursion.MediumQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of distinct integers candidates and a target integer target, return a list of all 
unique combinations of candidates where the chosen numbers sum to target. You may return the 
combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are 
unique if the frequency of at least one of the chosen numbers is different.

Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []
*/

public class Q39CombinationSum {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(arr, k, 0, list, 0);
        return res;
    }

    public void helper(int arr[], int k, int sum, ArrayList<Integer> list, int i) {

        if (sum == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < arr.length; j++) {
            if (sum + arr[j] > k) {
                continue;
            }
            list.add(arr[j]);
            helper(arr, k, sum + arr[j], list, j);
            list.remove(list.size() - 1);
        }
    }
}