package Strings.MediumQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]
*/

public class Q22GenerateParanthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, new char[2 * n], n, n, 0);
        return result;
    }

    public void helper(List<String> result, char[] array, int open, int close, int index) {
        
        if (open == 0 && close == 0) {
            result.add(new String(array));
            return;
        }

        if (open > 0) {
            array[index] = '(';
            helper(result, array, open - 1, close, index + 1);
        }

        if (close > open) {
            array[index] = ')';
            helper(result, array, open, close - 1, index + 1);
        }
    }
}