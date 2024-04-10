package Arrays.MeduimQuestions;

import java.util.HashMap;

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
        
        int[] prevSum = new int[nums.length + 1];
        prevSum[0] = 0;
        int sum = 0, result = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prevSum[i + 1] = sum;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < prevSum.length; i++) {
            // find number of pairs where difference = k
            if (map.containsKey(prevSum[i] - k)) {
                result += map.get(prevSum[i] - k);
            }
            map.put(prevSum[i], map.getOrDefault(prevSum[i], 0) + 1);
        }
        return result;
    }
}