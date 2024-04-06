package Strings.MediumQuestions;

/*
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"
*/

public class Q5LongestPalindromicString {

    int maxLen = 0;// length of longest palindrome
    int lo = 0;

    public String longestPalindrome(String s) {

        if (s.length() < 2)
            return s;

        char[] input = s.toCharArray();

        // i act as a centre of palindrome
        for (int i = 0; i < input.length; i++) {
            expandPalindrome(input, i, i);
            expandPalindrome(input, i, i + 1);
        }
        return s.substring(lo, lo + maxLen);
    }
}