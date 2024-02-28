package Maths.MediumQuestions;

public class Q7ReverseInteger {

    /*
    Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit 
    integer range [-231, 231 - 1], then return 0. Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

    Example 1:
    Input: x = 123
    Output: 321

    Example 2:
    Input: x = -123
    Output: -321

    Example 3:
    Input: x = 120
    Output: 21
    */

    static int reverse(int x) {

        int num = Math.abs(x);  
        int rev = 0; 
        
        while (num != 0) {
            int ld = num % 10; 
            // Overflow check
            if (rev > (Integer.MAX_VALUE - ld) / 10) 
                return 0;
            
            rev = rev * 10 + ld;  
            num = num / 10;
        }
        return (x < 0) ? (-rev) : rev;  
    }

    public static void main(String[] args) {
        
        System.out.println(reverse(-135));
    }
}