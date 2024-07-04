package Graphs.MediumQuestions;

/*
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
A move consists of walking from one land cell to another adjacent (4-directionally) land cell or 
walking off the boundary of the grid.
Return the number of land cells in grid for which we cannot walk off the boundary of the grid in 
any number of moves.

Example 1:
Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.

Example 2:
Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.
*/

public class Q1020NumberOfEnclaves {
    
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m<=2 || n<=2) return 0;
        for(int i=0; i<m; i++){
            if(grid[i][0]==1){
                dfs(grid, i, 0);
            }
            if(grid[i][n-1]==1){
                dfs(grid, i, n-1);
            }
        }
        for(int j=0; j<n; j++){
            if(grid[0][j]==1){
                dfs(grid, 0, j);
            }
            if(grid[m-1][j]==1){
                dfs(grid, m-1, j);
            }
        }
        int ans=0;
        for(int i=1; i<m-1; i++){
            for(int j=1; j<n-1; j++){
                ans+=grid[i][j];
            }
        }
        return ans;
    }
}