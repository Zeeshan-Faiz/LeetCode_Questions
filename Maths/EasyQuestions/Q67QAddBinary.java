package Maths.EasyQuestions;

public class Q67QAddBinary {

    /*
     * Given two binary strings a and b, return their sum as a binary string.
     * 
     * Example 1:
     * Input: a = "11", b = "1"
     * Output: "100"
     * 
     * Example 2:
     * Input: a = "1010", b = "1011"
     * Output: "10101"
     */

    static String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0) {
                carry = carry + a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                carry = carry + b.charAt(j) - '0';
                j--;
            }

            sb.append(carry % 2);
            carry = carry / 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        
        System.out.println(addBinary("1010", "1011"));
    }
}