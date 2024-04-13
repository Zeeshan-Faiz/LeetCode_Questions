package Recursion.MediumQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
*/

public class Q90SubsetII {
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        subSet(nums, 0, ans, list);
        return ans;
    }

    public void subSet(int[] nums,int idx,List<List<Integer>> ans,LinkedList<Integer> list) {
        
        ans.add(new ArrayList<>(list));

        for (int i = idx; i < nums.length; i++) {
            //taking care of the duplicate elements
            if (i > idx && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            subSet(nums, i + 1, ans, list);
            list.removeLast();
        }
    }
}