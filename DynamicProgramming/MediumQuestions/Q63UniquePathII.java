package DynamicProgramming.MediumQuestions;

import java.util.Arrays;

/*
You are given an m x n integer array grid. There is a robot initially located at the top-left 
corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner 
(i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes 
cannot include any square that is an obstacle. Return the number of possible unique paths that 
the robot can take to reach the bottom-right corner.
The testcases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:
Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

Example 2:
Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
*/

public class Q63UniquePathII {

    public int uniquePathsWithObstacles(int[][] grid) {
        // fixed starting and ending point
        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1)
            return 0;

        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return findPaths(n - 1, m - 1, grid, dp);
    }

    private int findPaths(int i, int j, int[][] grid, int[][] dp) {
        
        // out of bound conditions
        if (i < 0 || j < 0)
            return 0;
        // base condition
        if (i == 0 && j == 0)
            return 1;
        // check if obstacle
        if (grid[i][j] == 1)
            return 0;
        // check if previously calculated
        if (dp[i][j] != -1)
            return dp[i][j];

        // move up
        int up = findPaths(i - 1, j, grid, dp);
        // move left
        int left = findPaths(i, j - 1, grid, dp);

        return dp[i][j] = (up + left);
    }
}