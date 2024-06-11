package Strings.EasyQuestions;

/*
Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the 
maximum number of nested parentheses.

Example 1:
Input: s = "(1+(2*3)+((8)/4))+1"
Output: 3
Explanation:
Digit 8 is inside of 3 nested parentheses in the string.

Example 2:
Input: s = "(1)+((2))+(((3)))"
Output: 3
Explanation:
Digit 3 is inside of 3 nested parentheses in the string.

Example 3:
Input: s = "()(())((()()))"
Output: 3
*/

public class Q1614MaxNestingDepth {
    
    public int maxDepth(String s) {
        int ans = 0;
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                count++;
                ans = Math.max(ans,count);
            }else if (ch == ')'){
                count--;
            }
        }
        return ans;
    }
}