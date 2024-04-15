package Recursion.MediumQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that 
the number could represent. Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 
does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]
*/

public class Q17LetterCombinationOfKeypad {

    List<String> res = new ArrayList<>();
    String[] val = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        
        if (digits == null || digits.length() == 0)
            return res;
        
        helper(0, new StringBuilder(), digits);
        return res;
    }

    private void helper(int ind, StringBuilder sb, String digits) {
        
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String str = val[digits.charAt(ind) - '0'];
        for (char c : str.toCharArray()) {
            sb.append(c);
            helper(ind + 1, sb, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}