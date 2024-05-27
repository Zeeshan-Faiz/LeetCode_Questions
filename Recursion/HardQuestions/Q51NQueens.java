package Recursion.HardQuestions;

import java.util.ArrayList;
import java.util.List;

/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two 
queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the 
answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' 
and '.' both indicate a queen and an empty space, respectively.

Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:
Input: n = 1
Output: [["Q"]]
*/

public class Q51NQueens {
    
    public List<List<String>> solveNQueens(int n) {
         List<List<String>> res = new ArrayList<>();
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		int[] leftRow = new int[n];
		int[] upperDiagonal = new int[2 * n - 1];
		int[] lowerDiagonal = new int[2 * n - 1];
		nQueens(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
		return res;
    }
}