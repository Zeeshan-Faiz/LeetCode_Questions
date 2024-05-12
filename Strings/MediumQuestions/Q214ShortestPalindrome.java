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

    private void helper(char[] arr, int n, StringBuilder sb) {
        
        int i = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (arr[j] == arr[i]) {
                i++;
            }
        }
        if (i == n) {
            sb.append(arr, 0, n);
            return;
        }
        for (int j = n - 1; j >= i; j--) {
            sb.append(arr[j]);
        }
        helper(arr, i, sb);
        sb.append(arr, i, n - i);
    }
}