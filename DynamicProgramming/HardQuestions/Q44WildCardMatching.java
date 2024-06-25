package DynamicProgramming.HardQuestions;

/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for 
'?' and '*' where:
    '?' Matches any single character.
    '*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:
Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
*/

public class Q44WildCardMatching {

    public boolean isMatch(String s, String p) {
        int sIndex = 0, pIndex = 0, matchIndex = 0, starIndex = -1;

        while (sIndex < s.length()) {
            if (pIndex < p.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?')) {
                sIndex++;
                pIndex++;
            } 
            else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                starIndex = pIndex;
                matchIndex = sIndex;
                pIndex++;
            } 
            else if (starIndex != -1) {
                pIndex = starIndex + 1;
                matchIndex++;
                sIndex = matchIndex;
            } 
            else 
                return false;
        }

        while (pIndex < p.length() && p.charAt(pIndex) == '*') {
            pIndex++;
        }
        return pIndex == p.length();
    }
}