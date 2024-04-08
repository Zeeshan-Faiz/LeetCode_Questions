package Strings.MediumQuestions;

/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 
and num2, also represented as a string.
Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"
*/

public class Q43MultiplyStrings {
    
    public String multiply(String num1, String num2) {

        final int m = num1.length();
       final int n = num2.length();
   
       StringBuilder sb = new StringBuilder();
       int[] pos = new int[m + n];
   
       for (int i = m - 1; i >= 0; --i)
         for (int j = n - 1; j >= 0; --j) {
           final int multiply = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
           final int sum = multiply + pos[i + j + 1];
           pos[i + j] += sum / 10;
           pos[i + j + 1] = sum % 10;
         }
   
       for (final int p : pos)
         if (p > 0 || sb.length() > 0)
           sb.append(p);
   
       return sb.length() == 0 ? "0" : sb.toString();
       }
}