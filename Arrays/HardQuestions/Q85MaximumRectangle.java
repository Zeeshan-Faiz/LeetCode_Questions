package Arrays.HardQuestions;

import java.util.Arrays;

/*
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle 
containing only 1's and return its area.

Example 1:
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.

Example 2:
Input: matrix = [["0"]]
Output: 0

Example 3:
Input: matrix = [["1"]]
Output: 1
*/

public class Q85MaximumRectangle {
    
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[] heights = new int[n];
        int[] leftBoundaries = new int[n];
        int[] rightBoundaries = new int[n];
        Arrays.fill(rightBoundaries, n);

        int maxRectangle = 0;

        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n;

            updateHeightsAndLeftBoundaries(matrix[i], heights, leftBoundaries, left);

            updateRightBoundaries(matrix[i], rightBoundaries, right);

            maxRectangle = calculateMaxRectangle(heights, leftBoundaries, rightBoundaries, maxRectangle);
        }

         maxRectangle = calculateMaxRectangle(heights, leftBoundaries, rightBoundaries, maxRectangle);

        return maxRectangle;
    }
}