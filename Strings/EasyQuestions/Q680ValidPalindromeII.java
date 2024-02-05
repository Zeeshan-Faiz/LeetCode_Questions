package Strings.EasyQuestions;

/*
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Example 1:
Input: s = "aba"
Output: true

Example 2:
Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Example 3:
Input: s = "abc"
Output: false
*/

public class Q680ValidPalindromeII {

    static boolean validPalindrome(String s) {

        int i = 0, j = s.length() - 1;
            
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
                }
                i++;
                j--;
            }
            return true;
        }
        
    //check for palindrome by deleting the the char at first idx or last idx
    static boolean isPalindrome(String s, int i, int j) {
        
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        
        System.out.println(validPalindrome("abca"));
    }  
}
