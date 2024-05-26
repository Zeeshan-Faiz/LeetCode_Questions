package DynamicProgramming.HardQuestions;

import java.util.Arrays;

/*
Given a wooden stick of length n units. The stick is labelled from 0 to n. For example, 
a stick of length 6 is labelled as follows:
Given an integer array cuts where cuts[i] denotes a position you should perform a cut at. The cost 
of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts. 
When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is 
the length of the stick before the cut). Please refer to the first example for a better explanation.

Return the minimum total cost of the cuts.

Example 1:
Input: n = 7, cuts = [1,3,4,5]
Output: 16
Explanation: Using cuts order = [1, 3, 4, 5] as in the input leads to the following scenario:
The first cut is done to a rod of length 7 so the cost is 7. The second cut is done to a rod of 
length 6 (i.e. the second part of the first cut), the third is done to a rod of length 4 and the 
last cut is to a rod of length 3. The total cost is 7 + 6 + 4 + 3 = 20.
Rearranging the cuts to be [3, 5, 1, 4] for example will lead to a scenario with total cost = 16 
(as shown in the example photo 7 + 4 + 3 + 2 = 16).
*/

public class Q1547MinCostToCutStick {

    public int minCost(int n, int[] cuts) {
        
        Arrays.sort(cuts);
        int m = cuts.length + 2;
        int[] pos = new int[m];
        for (int i = 1; i < m - 1; ++i)
            pos[i] = cuts[i - 1];
        pos[m - 1] = n;
        int[][] dp = new int[m][m], mid = new int[m][m];

        for (int l = 0; l < m; ++l) 
        {
            for (int i = 0; i + l < m; ++i) 
            {
                int j = i + l;
                if (2 > l) {
                    mid[i][j] = i;
                    continue;
                }
                dp[i][j] = pos[j] - pos[i];
                int min = Integer.MAX_VALUE;
                for (int k = mid[i][j - 1]; k <= mid[i + 1][j]; ++k) {
                    int next = dp[i][k] + dp[k][j];
                    if (next < min) {
                        min = next;
                        mid[i][j] = k;
                    }
                }
                dp[i][j] += min;
            }
        }
        return dp[0][m - 1];
    }
}