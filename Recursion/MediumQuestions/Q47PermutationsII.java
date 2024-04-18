package Recursion.MediumQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of numbers, nums, that might contain duplicates, return all possible 
unique permutations in any order.

Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]

Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
*/

public class Q47PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        helper(ans, new ArrayList<>(), nums, new boolean[nums.length]);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> temp, int[] nums, boolean[] vis) {

        if (nums.length == temp.size()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (vis[i])
                continue; // if current element is already present in the temp, skip the element
            if (i > 0 && !vis[i - 1] && nums[i] == nums[i - 1])
                continue; // if prev element and current element is equal, skip the element

            vis[i] = true;
            temp.add(nums[i]);

            helper(ans, temp, nums, vis);

            // backtracking
            temp.remove(temp.size() - 1);
            vis[i] = false;
        }
    }
}