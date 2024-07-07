package Graphs.MediumQuestions;

import java.util.LinkedList;
import java.util.Queue;

/*
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. 
If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right 
cell (i.e., (n - 1, n - 1)) such that:
    All the visited cells of the path are 0.
    All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).

The length of a clear path is the number of visited cells of this path.

Example 1:
Input: grid = [[0,1],[1,0]]
Output: 2

Example 2:
Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4

Example 3:
Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
*/

public class Q1091ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if (grid[0][0] == 1)
            return -1;
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 });
        grid[0][0] = 1;
        int len = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int j = cell[0], k = cell[1];
                if (j == n - 1 && k == n - 1)
                    return len; // reached boundary

                // Iterate over neighboring cells
                for (int rc = j - 1; rc <= j + 1; rc++) {
                    for (int cc = k - 1; cc <= k + 1; cc++) {
                        // Check for valid cell coordinates and if the cell is not blocked
                        if (rc >= 0 && rc < n && cc >= 0 && cc < n && grid[rc][cc] == 0) {
                            q.offer(new int[] { rc, cc });
                            grid[rc][cc] = 1; // mark visiting
                        }
                    }
                }

            }
            len++;
        }
        return -1;
    }
}