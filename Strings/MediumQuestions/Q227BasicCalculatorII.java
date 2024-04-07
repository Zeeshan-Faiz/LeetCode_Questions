package Strings.MediumQuestions;

/*
Given a string s which represents an expression, evaluate this expression and return its value. 
The integer division should truncate toward zero.
You may assume that the given expression is always valid. All intermediate results will be in the 
range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical 
expressions, such as eval().

Example 1:
Input: s = "3+2*2"
Output: 7

Example 2:
Input: s = " 3/2 "
Output: 1

Example 3:
Input: s = " 3+5 / 2 "
Output: 5
*/

public class Q227BasicCalculatorII {

    public int calculate(String s) {

        if (s == null || s.length() == 0)
            return 0;

        int answer = 0;
        int currentNumber = 0;
        int lastNumber = 0;
        char operator = '+';

        for (int i = 0; i < s.length(); i++) {
            
            char ch = s.charAt(i);
            
            //ch is a digit(0-9)
            if (ch >= 48 && ch <= 57) {
                currentNumber = currentNumber * 10 + ch - '0';
            }
            if (i == s.length() - 1 || isOperator(ch)) 
            {
                if (operator == '+') {
                    answer += lastNumber;
                    lastNumber = currentNumber;
                } 
                else if (operator == '-') {
                    answer += lastNumber;
                    lastNumber = -currentNumber;
                } 
                else if (operator == '*') {
                    lastNumber *= currentNumber;
                } 
                else if (operator == '/') {
                    lastNumber /= currentNumber;
                }
                operator = ch;
                currentNumber = 0;
            }
        }
        answer += lastNumber;
        return answer;
    }

    private boolean isOperator(char c) {
        return c == '*' || c == '/' || c == '-' || c == '+';
    }
}