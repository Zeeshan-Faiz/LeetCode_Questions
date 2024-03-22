package BinarySearch.MediumQuestions;

/*
You are given an integer array nums where the ith bag contains nums[i] balls. You are also given an
integer maxOperations.
You can perform the following operation at most maxOperations times:
    Take any bag of balls and divide it into two new bags with a positive number of balls.
    For example, a bag of 5 balls can become two new bags of 1 and 4 balls, or two new bags of 2 and 3 balls.

Your penalty is the maximum number of balls in a bag. You want to minimize your penalty after the 
operations.
Return the minimum possible penalty after performing the operations.

Example 1:

Input: nums = [9], maxOperations = 2
Output: 3
Explanation: 
- Divide the bag with 9 balls into two bags of sizes 6 and 3. [9] -> [6,3].
- Divide the bag with 6 balls into two bags of sizes 3 and 3. [6,3] -> [3,3,3].
The bag with the most number of balls has 3 balls, so your penalty is 3 and you should return 3.

Example 2:
Input: nums = [2,4,8,2], maxOperations = 4
Output: 2
Explanation:
- Divide the bag with 8 balls into two bags of sizes 4 and 4. [2,4,8,2] -> [2,4,4,4,2].
- Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,4,4,4,2] -> [2,2,2,4,4,2].
- Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,4,4,2] -> [2,2,2,2,2,4,2].
- Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,2,2,4,2] -> [2,2,2,2,2,2,2,2].
The bag with the most number of balls has 2 balls, so your penalty is 2, and you should return 2.
*/

public class Q1760MinimumLimitsOfBall {

    static int minimumSize(int[] nums, int maxOperations) {
        
        //The answer should be the minimized max value.
        int min = 0;
        int max = 1000000000;
        
        while (min + 1 < max) {
            
            int mid = min + (max - min) / 2;
            //count indicates the operation times with atmost mid balls in bag.
            int count = 0;
            for (int a : nums) {
                // Find the number of divided bags, we subtract the number by 1 to get the subdivision operation times.
                count = count + (a - 1) / mid;
            }
            // Case 1 : if count < maxOperations, max WOULD be further minimized and set to mid;
            // Case 2 : if count = maxOperations, max still COULD be further minimized and set to mid.
            if (count <= maxOperations) {
                // To not miss the correct answer we set a relatively "loose" boundary for max and min.
                max = mid;
            } 
            else 
                min = mid;
        }
        // Now we return the minimized max value
        return max;
    }
}