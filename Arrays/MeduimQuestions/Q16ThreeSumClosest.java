package Arrays.MeduimQuestions;

import java.util.Arrays;

/*
Given an integer array nums of length n and an integer target, find three integers in nums such
that the sum is closest to target. Return the sum of the three integers.
You may assume that each input would have exactly one solution.

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Example 2:
Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
*/

public class Q16ThreeSumClosest {
    
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        if(target<=nums[0]+nums[1]+nums[2]) return nums[0]+nums[1]+nums[2];
        if(target>=nums[len-1]+nums[len-2]+nums[len-3]) return nums[len-1]+nums[len-2]+nums[len-3];
        int minSum = Integer.MAX_VALUE;
        int closest = 0;
        // System.out.println(Arrays.toString(nums));
        for(int i=0; i<nums.length-2; i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k = nums.length-1;
            while(j<k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(minSum>Math.abs(target-sum)) { 
                    // System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
                    minSum = Math.abs(target-sum);
                    if(minSum == 0) return sum;
                    closest = sum;
                }
                if(sum<target) j++;
                else k--;
            }
        }
        return closest;
    }
}