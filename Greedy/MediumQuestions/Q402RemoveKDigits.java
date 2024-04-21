package Greedy.MediumQuestions;

/*
Given string num representing a non-negative integer num, and an integer k, return the smallest 
possible integer after removing k digits from num.

Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
*/

public class Q402RemoveKDigits {
    
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        char[] chars = new char[num.length()];
        int size = 0;
        for (char c : num.toCharArray()) {
            if (c == '0' && size <= k) {
                k -= size;
                size = 0;
            } else {
                while (k > 0 && size > 0 && c < chars[size - 1]) {
                    size--;
                    k--;
                }
                chars[size++] = c;
            }
        }
        size -= k;        
        return size <= 0 ? "0" : String.valueOf(chars, 0, size);
    }
}