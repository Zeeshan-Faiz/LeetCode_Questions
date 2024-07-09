package Graphs.MediumQuestions;

/*
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of 
travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the 
target node, and wi is the time it takes for a signal to travel from source to target.
We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to 
receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

Example 1:
Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2

Example 2:
Input: times = [[1,2,1]], n = 2, k = 1
Output: 1

Example 3:
Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
*/

public class Q743NetworkDelayTime {

    int INF = Integer.MAX_VALUE;

    public int networkDelayTime(int[][] times, int n, int k) {
        
        if (times.length < n - 1)
            return -1;

        int mat[][] = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                mat[i][j] = i == j ? 0 : INF;
            }
        }
        for (int t[] : times) {
            mat[t[0]][t[1]] = t[2];
        }

        int dp[] = mat[k];
        boolean visited[] = new boolean[n + 1];
        visited[k] = true;
        for (int i = 0; i < n - 1; i++) {
            int minTime = INF;
            int v = 0;

            for (int j = 1; j < n + 1; j++) {
                if (!visited[j] && minTime > dp[j]) {
                    minTime = dp[j];
                    v = j;
                }
            }

            // has no any node can be reached
            if (minTime == INF)
                return -1;

            visited[v] = true;

            for (int j = 1; j < n + 1; j++) {
                // d(k,j) = d(k,v)+d(v,j) when kvj is smaller than kj
                if (mat[k][j] - mat[k][v] > mat[v][j]) {
                    dp[j] = dp[v] + mat[v][j];
                }
            }
        }

        int minTime = 0;
        for (int i = 1; i < n + 1; i++)
            if (i != k)
                minTime = Math.max(minTime, dp[i]);

        return minTime == 0 ? -1 : minTime;
    }
}