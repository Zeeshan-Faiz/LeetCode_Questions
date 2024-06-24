package DynamicProgramming.MediumQuestions;

/*
Given two strings word1 and word2, return the minimum number of steps required to make word1 
and word2 the same.
In one step, you can delete exactly one character in either string.

Example 1:
Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

Example 2:
Input: word1 = "leetcode", word2 = "etco"
Output: 4
*/

public class Q583DeleteOperationForTwoStrings {

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        char[] word1Chars = word1.toCharArray();
        char[] word2Chars = word2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1Chars[i] == word2Chars[j]) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return (m - dp[m][n]) + (n - dp[m][n]);
    }
}