package Graphs.HardQuestions;

/*
You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation 
at that point (i, j). The rain starts to fall. At time t, the depth of the water everywhere is t. 
You can swim from a square to another 4-directionally adjacent square if and only if the elevation 
of both squares individually are at most t. You can swim infinite distances in zero time. Of 
course, you must stay within the boundaries of the grid during your swim.
Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at 
the top left square (0, 0).

Example 1:
Input: grid = [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.

Example 2:
Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation: The final route is shown.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
*/

public class Q778SwimInRisingWater {

    int len;
    final static int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int swimInWater(int[][] grid) {
        
        len = grid.length;
        int left = Math.max(grid[0][0], grid[len - 1][len - 1]), right = len * len - 1, mid, res = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            boolean[] seen = new boolean[len * len];
            if (dfs(0, 0, grid, mid, seen)) {
                res = mid;
                right = mid - 1;
            } 
            else
                left = mid + 1;
            
        }
        return res;
    }

    public boolean dfs(int xn, int yn, int[][] grid, int mid, boolean[] seen) {
        
        int idx = xn * len + yn;
        if (seen[idx])
            return true;
        seen[idx] = true;
        for (int i = 0; i < 4; i++) {
            int newx = xn + dirs[i][0], newy = yn + dirs[i][1];
            if (newx >= 0 && newx < len && newy >= 0
                    && newy < len && !seen[newx * len + newy] && grid[newx][newy] <= mid) {
                if (newx == len - 1 && newy == len - 1) {
                    return true;
                }
                if (dfs(newx, newy, grid, mid, seen)) {
                    return true;
                }
            }
        }
        return false;
    }
}