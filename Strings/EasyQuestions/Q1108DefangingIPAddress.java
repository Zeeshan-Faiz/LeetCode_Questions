package Strings.EasyQuestions;

/*
Given a valid (IPv4) IP address, return a defanged version of that IP address.
A defanged IP address replaces every period "." with "[.]".

Example 1:
Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"

Example 2:
Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"
*/
public class Q1108DefangingIPAddress {

    static String defangIPaddr(String address) {
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char ch = address.charAt(i);

            if (ch == '.') {
                result.append("[.]");
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        
        System.out.println(defangIPaddr("1.1.1.1"));
    }
    
}
