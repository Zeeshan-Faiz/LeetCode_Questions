package Graphs.MediumQuestions;

/*
You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are 
surrounded:
    Connect: A cell is connected to adjacent cells horizontally or vertically.
    Region: To form a region connect every 'O' cell.
    Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
A surrounded region is captured by replacing all 'O's with 'X's in the input matrix board.\

Example 1:
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

Example 2:
Input: board = [["X"]]
Output: [["X"]]
*/

public class Q130SurroundedRegions {
    
    public void solve(char[][] board) {
        int n=board.length, m=board[0].length;
        for(int i=0;i<n;i++){
            dfs(board,i,0,n,m);
        }
        for(int i=0;i<n;i++){
            dfs(board,i,m-1,n,m);
        }
        for(int j=0;j<m;j++){
            dfs(board,0,j,n,m);
        }
        for(int j=0;j<m;j++){
            dfs(board,n-1,j,n,m);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
}