package Strings.MediumQuestions;

import java.util.Stack;

/*
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is 
being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square 
brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain
any digits and that digits are only for those repeat numbers, k. For example, there will not be 
input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
*/

public class Q394DecodeString {
    
    public String decodeString(String s) {
        
        Stack<Integer> repeatTimes = new Stack<>(); // this will store the current sb to repeat how many times
        Stack<StringBuilder> substrs = new Stack<>();   // this will store the last created substring

        char[] sarr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int n = 0;

        for(int i=0;i<sarr.length;i++) {
            if(Character.isDigit(sarr[i])) {
                n = n * 10 + (sarr[i] - '0');   // to conver char to number.
            }else if(sarr[i] == '[') {
                repeatTimes.push(n);    // Push the last found to repeatTimes
                n = 0;  // reset for next n
                substrs.push(sb);   // Store the current sb i.e. been made
                sb = new StringBuilder();   // create new sb for reading the characters after current [
            }else if(sarr[i] == ']') {  // if reached ] then sb will have the value between [...]
                int k = repeatTimes.pop(); // no of times to repeat the current sb
                StringBuilder temp = sb;    // copy the current sb to temp
                sb = substrs.pop(); // pop the last created substring

                while(k-->0) {  // append the current substring to sb. So after this as it will get [ it will append the constructed substring again to stack to which we will again append the next encoding.
                    sb.append(temp);
                }
            }else {
                sb.append(sarr[i]);
            }
        }
        return sb.toString();
    }
}