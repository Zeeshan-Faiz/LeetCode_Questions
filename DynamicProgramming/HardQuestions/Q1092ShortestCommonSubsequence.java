package DynamicProgramming.HardQuestions;

/*
Given two strings str1 and str2, return the shortest string that has both str1 and str2 as 
subsequences. If there are multiple valid strings, return any of them.
A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) 
results in the string s.

Example 1:
Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation: 
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.

Example 2:
Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
Output: "aaaaaaaa"
*/

public class Q1092ShortestCommonSubsequence {

    public String shortestCommonSupersequence(String str1, String str2) {

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int l1 = ch1.length;
        int l2 = ch2.length;
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (ch1[i - 1] == ch2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = l1;
        int j = l2;
        while (i > 0 && j > 0) {
            if (ch1[i - 1] == ch2[j - 1]) {
                sb.append(ch1[i - 1]);
                i--;
                j--;
            } else {
                if (dp[i][j] == dp[i - 1][j]) {
                    sb.append(ch1[i - 1]);
                    i--;
                } else {
                    sb.append(ch2[j - 1]);
                    j--;
                }
            }
        }
        if (i == 0 && j != 0) {
            while (j > 0) {
                sb.append(ch2[j - 1]);
                j--;
            }
        }
        if (i != 0 && j == 0) {
            while (i > 0) {
                sb.append(ch1[i - 1]);
                i--;
            }
        }
        sb.reverse();
        return sb.toString();
    }
}