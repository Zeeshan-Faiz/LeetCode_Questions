package DynamicProgramming.HardQuestions;

/*
Given a string s. In one step you can insert any character at any index of the string.
Return the minimum number of steps to make s palindrome.
A Palindrome String is one that reads the same backward as well as forward.

Example 1:
Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we do not need any insertions.

Example 2:
Input: s = "mbadm"
Output: 2
Explanation: String can be "mbdadbm" or "mdbabdm".

Example 3:
Input: s = "leetcode"
Output: 5
Explanation: Inserting 5 characters the string becomes "leetcodocteel".
*/

public class Q1312MinInsertionToMakePalindrome {

    public int minInsertions(String s) {
        
        char a[] = s.toCharArray();
        int n = a.length;
        int dp[] = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                int nxt = dp[j];
                if (a[i] == a[j])
                    dp[j] = 2 + max;
                max = Math.max(max, nxt);
            }
        }
        int max = 0;
        for (int i : dp)
            max = Math.max(i, max);

        return n - max;
    }
}