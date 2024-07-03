package Graphs.MediumQuestions;

/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly 
with city b, and city b is connected directly with city c, then city a is connected indirectly with
city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the 
group. You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and 
the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
Return the total number of provinces.

Example 1:
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2

Example 2:
Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
*/

public class Q547NumberOfProvinces {
    
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        for(int i = 0; i < isConnected.length; i++){
            if(isConnected[i][i] != -1){
                visit(i, isConnected);
                ans++;
            }
        }
        return ans;
    }

    public void visit(int i, int[][] isConnected){
        if(i < 0|| i >= isConnected.length || isConnected[i][i] == -1)
            return;
        isConnected[i][i] = -1;
        for(int j = 0; j < isConnected.length; j++){
            if(isConnected[i][j] == 1 && isConnected[j][j] != -1)
                visit(j, isConnected);
        }
        return;
    }
}