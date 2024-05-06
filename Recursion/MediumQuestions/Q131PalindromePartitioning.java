package Recursion.MediumQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s, partition s such that every substring of the partition is a palindrome. Return 
all possible palindrome partitioning of s.

Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:

Input: s = "a"
Output: [["a"]]
*/

public class Q131PalindromePartitioning {

    public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        helper(s, 0, new ArrayList<String>(), result);
        return result;
    }

    private void helper(String s, int start, List<String> list, List<List<String>> result) {
        
        if (start == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                list.add(s.substring(start, i + 1));
                helper(s, i + 1, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}