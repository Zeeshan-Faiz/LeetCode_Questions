package Arrays.EasyQuestions.Strings;

/*
Difficulty = Easy
Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). 
You must also not convert the inputs to integers directly.

Example 1:
Input: num1 = "11", num2 = "123"
Output: "134"

Example 2:
Input: num1 = "456", num2 = "77"
Output: "533"

Example 3:
Input: num1 = "0", num2 = "0"
Output: "0"

*/

public class Q415AddStrings {

    static String addStrings(String num1, String num2) {
        
        String res = "";
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int carry = 0;
        int ivalue = Integer.MIN_VALUE;
        int jvalue = Integer.MIN_VALUE;
        while(i >= 0 || j >= 0 || carry != 0){
            
            if(i >= 0)
                ivalue = num1.charAt(i) - '0';
            else
                ivalue = 0;
            
            if(j >= 0)
                jvalue = num2.charAt(j) - '0';
            else
                jvalue = 0;
            
            i--;
            j--;

            int sum = ivalue + jvalue + carry;
            int rval = sum % 10;
            res = rval + res;
            carry = sum / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        
        System.out.println(addStrings("123", "11"));
    }
}
