package DynamicProgramming.HardQuestions;

/*
Given two strings s and t, return the number of distinct subsequences of s which equals t.
The test cases are generated so that the answer fits on a 32-bit signed integer.

Example 1:
Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
rabbbit
rabbbit

Example 2:
Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from s.
babgbag
babgbag
babgbag
babgbag
babgbag
*/

public class Q115DistinctSubsequence {
    
    public int numDistinct(String source, String target) {
        int[] sums = new int[target.length() + 1]; // 1 indexed
        sums[0] = 1;
        int maxIndex = 0;
        char[] targetArr = target.toCharArray();
        char[] sourceArr = source.toCharArray();
        for (int i = 0; i < sourceArr.length; i++) {
            char sourceChar = sourceArr[i];
            if (maxIndex < targetArr.length - 1 && sourceChar == targetArr[maxIndex]) maxIndex++;
            int minIndex = Math.max(0, i - sourceArr.length + targetArr.length);
            for (int j = maxIndex; j >= minIndex; j--) {
                if (sourceChar == targetArr[j]) {
                    sums[j + 1] += sums[j]; // 1 indexed
                }
            }
        }
        return sums[sums.length - 1];
    }
}