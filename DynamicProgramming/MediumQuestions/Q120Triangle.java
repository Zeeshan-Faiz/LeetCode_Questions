package DynamicProgramming.MediumQuestions;

import java.util.Arrays;
import java.util.List;

/*
Given a triangle array, return the minimum path sum from top to bottom.
For each step, you may move to an adjacent number of the row below. More formally, if you are 
on index i on the current row, you may move to either index i or index i + 1 on the next row.

Example 1:
Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

Example 2:
Input: triangle = [[-10]]
Output: -10
*/

public class Q120Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        
        int m = triangle.size();
        int dp[][] = new int[m][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(triangle, 0, 0, m, dp);
    }

    public int helper(List<List<Integer>> triangle , int row , int col , int m , int[][] dp){
        
        if(row==m)
            return 0;
        
        if(dp[row][col] != -1)
            return dp[row][col];
        
        int  sum1 = triangle.get(row).get(col) + helper(triangle , row+1 , col , m , dp);
        int  sum2 = triangle.get(row).get(col) + helper(triangle , row+1 , col+1 , m , dp);
        
        return dp[row][col] = Math.min(sum1 , sum2);
    }
}