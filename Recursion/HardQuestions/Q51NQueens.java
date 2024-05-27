package Recursion.HardQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
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

    private static void nQueens(int col, char[][] board, List<List<String>> res, int[] leftRow, int[] lowerDiagnol,
			int[] upperDiagnol) {
		int n = board.length;
		if (col == n) {
			res.add(construct(board));
			return;
		}
		for (int row = 0; row < n; row++) {
			if (leftRow[row] == 0 && lowerDiagnol[row + col] == 0 && upperDiagnol[n - 1 + col - row] == 0) {
				board[row][col] = 'Q';
				leftRow[row] = 1;
				lowerDiagnol[row + col] = 1;
				upperDiagnol[n - 1 + col - row] = 1;
				nQueens(col + 1, board, res, leftRow, lowerDiagnol, upperDiagnol);
				board[row][col] = '.';
				leftRow[row] = 0;
				lowerDiagnol[row + col] = 0;
				upperDiagnol[n - 1 + col - row] = 0;
			}
		}
	}
	private static List<String> construct(char[][] board) {
		int n = board.length;
		List<String> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String s = new String(board[i]);
			list.add(s);
		}
		return list;
	}
}