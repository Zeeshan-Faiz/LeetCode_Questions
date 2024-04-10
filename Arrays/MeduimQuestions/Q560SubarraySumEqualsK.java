package Arrays.MeduimQuestions;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums and an integer k, return the total number of subarrays whose 
sum equals to k. A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2
*/

public class Q560SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {

        int[] sum = new int[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i <= nums.length; i++) {
            if (map.containsKey(sum[i] - k))
                count += map.get(sum[i] - k);
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }

        return count;
    }
}