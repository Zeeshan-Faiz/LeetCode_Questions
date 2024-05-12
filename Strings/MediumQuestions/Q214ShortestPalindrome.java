package Strings.MediumQuestions;

/*
You are given a string s. You can convert s to a palindrome by adding characters in front of it.
Return the shortest palindrome you can find by performing this transformation.

Example 1:
Input: s = "aacecaaa"
Output: "aaacecaaa"

Example 2:
Input: s = "abcd"
Output: "dcbabcd"
*/

public class Q214ShortestPalindrome {

    public String shortestPalindrome(String s) {
        
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(arr, arr.length, sb);
        return sb.toString();
    }
}