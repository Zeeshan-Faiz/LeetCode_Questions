package Strings.MediumQuestions;

/*
Given two strings a and b, return the minimum number of times you should repeat string a so that 
string b is a substring of it. If it is impossible for b​​​​​​ to be a substring of a after repeating it,
return -1.
Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is 
"abcabc".

Example 1:
Input: a = "abcd", b = "cdabcdab"
Output: 3
Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.

Example 2:
Input: a = "a", b = "aa"
Output: 2
*/

public class Q686RepeatedStringMatch {

    public int repeatedStringMatch(String a, String b) {
        
        boolean[] bucket = new boolean[26];
        for (char c : a.toCharArray())
            bucket[c - 'a'] = true;
        
        for (char c : b.toCharArray())
            if (!bucket[c - 'a'])
                return -1;

        int cnt = b.length() / a.length();

        StringBuilder sb = new StringBuilder(a.repeat(cnt));

        for (int i = 0; i < 3; i++) {
            if (sb.indexOf(b) >= 0)
                return cnt + i;
            sb.append(a);
        }
        return -1;
    }
}