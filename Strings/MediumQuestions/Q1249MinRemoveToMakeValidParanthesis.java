package Strings.MediumQuestions;

/*
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that 
the resulting parentheses string is valid and return any valid string.
Formally, a parentheses string is valid if and only if:

    It is the empty string, contains only lowercase characters, or
    It can be written as AB (A concatenated with B), where A and B are valid strings, or
    It can be written as (A), where A is a valid string.

Example 1:
Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

Example 2:
Input: s = "a)b(c)d"
Output: "ab(c)d"

Example 3:
Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
*/

public class Q1249MinRemoveToMakeValidParanthesis {
    
    // Initialize pointers for the start and end of the string
    int startPointer = 0;
    int endPointer = s.length() - 1;

    // Initialize variables for storing start and end parts of the string, and the final result
    String startPart = "";
    String endPart = "";
    String result;

    // Convert input string to character array for easier manipulation
    char[] arr = s.toCharArray();
    
    // Counter for open parentheses
    int openParenthesesCount = 0;

    // First pass: mark excess closing parentheses with '*'
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == '(')
            openParenthesesCount++;
        else if (arr[i] == ')') {
            if (openParenthesesCount == 0)
                arr[i] = '*'; // Mark excess closing parentheses
            else
                openParenthesesCount--;
        }
    }

    // Second pass: mark excess opening parentheses from the end
    for (int i = arr.length - 1; i >= 0; i--) {
        if (openParenthesesCount > 0 && arr[i] == '(') {
            arr[i] = '*'; // Mark excess opening parentheses
            openParenthesesCount--;
        }
    }
    
    // Filter out marked characters and store the result in the character array
    int p = 0; // Pointer for updating the character array
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] != '*')
            arr[p++] = arr[i];
    }

    // Construct the result string from the filtered character array
    result = new String(arr).substring(0, p);

    return result;
}
}