/*
There are n servers numbered from 0 to n - 1 connected by undirected server-to-server 
connections forming a network where connections[i] = [ai, bi] represents a connection between 
servers ai and bi. Any server can reach other servers directly or indirectly through the network.
A critical connection is a connection that, if removed, will make some servers unable to reach 
some other server.
Return all critical connections in the network in any order.

Example 1:
Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.

Example 2:
Input: n = 2, connections = [[0,1]]
Output: [[0,1]]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1192CriticalConnectionsInANetwork {
    
    private int[] low;
    private int[] disc;
    private int time;
    private List<List<Integer>> criticalConnections;
    private int[][] graph;
    private int[] size;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // Initialize data structures
        low = new int[n];
        disc = new int[n];
        time = 0;
        criticalConnections = new ArrayList<>();
        graph = new int[n][];
        size = new int[n];

        // Count edges for each node
        for (List<Integer> conn : connections) {
            size[conn.get(0)]++;
            size[conn.get(1)]++;
        }

        // Allocate space for each node's neighbors
        for (int i = 0; i < n; i++) {
            graph[i] = new int[size[i]];
        }

        // Build the graph
        for (List<Integer> conn : connections) {
            int u = conn.get(0), v = conn.get(1);
            graph[u][--size[u]] = v;
            graph[v][--size[v]] = u;
        }

        // Find critical connections
        for (int i = 0; i < n; i++) {
            if (disc[i] == 0) {
                dfs(i, -1);
            }
        }

        return criticalConnections;
    }

    private void dfs(int u, int parent) {
        disc[u] = low[u] = ++time;

        for (int v : graph[u]) {
            if (v == parent) continue;

            if (disc[v] == 0) {
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    criticalConnections.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}