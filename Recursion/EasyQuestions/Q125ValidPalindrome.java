package Recursion.EasyQuestions;

public class Q125ValidPalindrome{
    /*
    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric 
    characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
    Given a string s, return true if it is a palindrome, or false otherwise.

    Example 1:
    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.

    Example 2:
    Input: s = "race a car"
    Output: false
    Explanation: "raceacar" is not a palindrome.

    Example 3:
    Input: s = " "
    Output: true
    Explanation: s is an empty string "" after removing non-alphanumeric characters.
    Since an empty string reads the same forward and backward, it is a palindrome.
    */

    static boolean isPalindrome(String s) {
        
        s = s.toLowerCase();
    	s = s.replaceAll("[^a-zA-Z0-9]", "");
    	return isPalindromeRecursive(s, 0, s.length()-1);
    }
    
    static boolean isPalindromeRecursive(String s, int start, int end) {
    	
    	if (start >= end)
    		return true;
    	
    	if (s.charAt(start) != s.charAt(end))
    		return false;
    	
    	return isPalindromeRecursive(s, start+1, end-1);
    }

    public static void main(String[] args) {
        
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}