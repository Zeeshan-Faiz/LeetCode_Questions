package BinarySearch.EasyQuestions;

/*
Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of 
negative numbers in grid.

Example 1:
Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.

Example 2:
Input: grid = [[3,2],[1,0]]
Output: 0
*/

public class Q1351CountNumberOfNegative {

    static int countNegatives(int[][] grid) {
        
        int count = 0;
        int m = grid.length;   
        int n = grid[0].length; 
        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n - 1;
            
            while (left <= right) {

                int mid = left + (right - left) / 2;
                
                if (grid[i][mid] < 0) 
                    right = mid - 1;
                else 
                    left = mid + 1;     
            }
            count += n - left; 
        }
        return count;
    }
    
}
