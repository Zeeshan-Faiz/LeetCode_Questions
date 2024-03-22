package Maths.MediumQuestions;

/*
Given two integers dividend and divisor, divide two integers without using multiplication, division, 
and mod operator. The integer division should truncate toward zero, which means losing its fractional part. For example, 
8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.
Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed 
integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1,
then return 231 - 1, and if the quotient is strictly less than -231, then return -231.

Example 1:
Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.

Example 2:
Input: dividend = 7, divisor = -3
Output: -2
*/

public class Q29DivideTwoIntegers {

    static int divide(int dividend, int divisor) {

        if (divisor == Integer.MIN_VALUE) 
            return dividend == Integer.MIN_VALUE ? 1 : 0;

        if (dividend == 0) 
            return 0;

        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) 
                return Integer.MIN_VALUE;
            else if (divisor == -1) 
                return Integer.MAX_VALUE;
        }

        boolean sign = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) 
            sign = true;

        if (dividend > 0) 
            dividend = -dividend;

        if (divisor > 0) 
            divisor = -divisor;

        int MAX = Integer.MIN_VALUE >> 1;
        int ans = 0;

        // dividend became negative
        while (dividend <= divisor) {
            int temp = divisor;
            int step = -1;

            while (temp >= MAX && step >= MAX && temp >= dividend - temp) {
                temp += temp;
                step += step;
            }

            dividend = dividend - temp;
            ans = ans + step;
        }
        return sign ? ans : -ans;
    }

    public static void main(String[] args) {

        System.out.println(divide(10, 3));
    }
}