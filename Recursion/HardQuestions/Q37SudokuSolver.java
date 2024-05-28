package Recursion.HardQuestions;

/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:
    Each of the digits 1-9 must occur exactly once in each row.
    Each of the digits 1-9 must occur exactly once in each column.
    Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
    The '.' character indicates empty cells.

Example 1:
Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:
*/

public class Q37SudokuSolver {

    public void solveSudoku(char[][] board) {
        int[][] f = new int[9][10];
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int cell = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cell = ((i / 3) * 3) + j / 3;
                if (board[i][j] != '.') {
                    f[cell][(int) (board[i][j] - '0')] = 1;
                    row[i][(int) (board[i][j] - '0')] = 1;
                    col[j][(int) (board[i][j] - '0')] = 1;
                }
            }
        }
        get(f, board, 0, 0, row, col);
        return;

    }

    static boolean get(int[][] f, char[][] board, int i, int j, int[][] row, int[][] col) {
        
        if (i == 9)
            return true;
        if (board[i][j] != '.') 
        {
            if (j == 8)
                return get(f, board, i + 1, 0, row, col);
            else
                return get(f, board, i, j + 1, row, col);
        } 
        else 
        {
            boolean t = false;
            int cell = ((i / 3) * 3) + j / 3;
            for (int k = 1; k <= 9; k++) {
                if (f[cell][k] == 0 && row[i][k] == 0 && col[j][k] == 0) 
                {
                    f[cell][k] = 1;
                    row[i][k] = 1;
                    col[j][k] = 1;
                    board[i][j] = (char) (k + '0');
                    if (j == 8)
                        t = get(f, board, i + 1, 0, row, col);
                    else
                        t = get(f, board, i, j + 1, row, col);
            
                    if (t)
                        return true;
                    f[cell][k] = 0;
                    row[i][k] = 0;
                    col[j][k] = 0;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }
}