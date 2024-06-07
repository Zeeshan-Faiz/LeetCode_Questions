package BinarySearch.MediumQuestions;

/*
Given an array of integers nums and an integer threshold, we will choose a positive integer 
divisor, divide all the array by it, and sum the division's result. Find the smallest divisor 
such that the result mentioned above is less than or equal to threshold.
Each result of the division is rounded to the nearest integer greater than or equal to that 
element. (For example: 7/3 = 3 and 10/2 = 5).
The test cases are generated so that there will be an answer.

Example 1:
Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 

Example 2:
Input: nums = [44,22,33,11,1], threshold = 5
Output: 44
*/

public class Q1283FindSmallestDivGreaterThanThreshold {
    
    public int smallestDivisor(int[] arr, int threshold) {
        int n = arr.length; // size of array.

    // Find the maximum element:
    int maxi = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      maxi = Math.max(maxi, arr[i]);
    }

    // Binary search to find the smallest divisor
    int left = 1, right = maxi;

    while (left < right) {
      int mid = left + (right - left) / 2;
      int sum = 0;

      // Calculate the sum of ceilings
      for (int i = 0; i < n; i++) {
        sum += (arr[i] + mid - 1) / mid; // equivalent to Math.ceil((double) arr[i] / mid)
      }

      if (sum <= threshold) {
        right = mid; // try for a smaller divisor
      } else {
        left = mid + 1; // increase the divisor
      }
    }

    return left;
    }
}