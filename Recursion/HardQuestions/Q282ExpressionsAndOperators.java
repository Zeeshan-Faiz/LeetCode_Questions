package Recursion.HardQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Given a string num that contains only digits and an integer target, return all possibilities to 
insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant 
expression evaluates to the target value.
Note that operands in the returned expressions should not contain leading zeros.

Example 1:
Input: num = "123", target = 6
Output: ["1*2*3","1+2+3"]
Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.

Example 2:
Input: num = "232", target = 8
Output: ["2*3+2","2+3*2"]
Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.

Example 3:
Input: num = "3456237490", target = 9191
Output: []
Explanation: There are no expressions that can be created from "3456237490" to evaluate to 9191.
*/

public class Q282ExpressionsAndOperators {

    List<String> res;
    char[] nums;
    long target;
    int n;
    char[] chs;

    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        nums = num.toCharArray();
        this.target = target;
        n = num.length();
        chs = new char[n + n];
        int chsPtr = 0;
        long value = 0;

        for (int i = 0; i < n; i++) {
            value = value * 10 + nums[i] - '0';
            chs[chsPtr++] = nums[i];

            helper(i + 1, chsPtr, 0, value);
            if (value == 0)
                break;
        }
        return res;
    }

    private void helper(int numPtr, int chsPtr, long curr, long prev) {
        
        if (numPtr == n) {
            if (curr + prev == target) {
                res.add(new String(chs, 0, chsPtr));

            }
            return;
        }

        long value = 0;
        int op = chsPtr++;
        for (int i = numPtr; i < n; i++) {
            value = value * 10 + nums[i] - '0';
            chs[chsPtr++] = nums[i];
            chs[op] = '+';
            helper(i + 1, chsPtr, curr + prev, value);
            chs[op] = '-';
            helper(i + 1, chsPtr, curr + prev, -value);
            chs[op] = '*';
            helper(i + 1, chsPtr, curr, prev * value);
            if (value == 0)
                break;
        }
    }
}