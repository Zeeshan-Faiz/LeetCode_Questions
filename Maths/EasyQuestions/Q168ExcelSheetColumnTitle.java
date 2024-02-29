package Maths.EasyQuestions;

public class Q168ExcelSheetColumnTitle {

    /*
    Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

    For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...

    Example 1:
    Input: columnNumber = 1
    Output: "A"

    Example 2:
    Input: columnNumber = 28
    Output: "AB"

    Example 3:
    Input: columnNumber = 701
    Output: "ZY"
    */

    static String convertToTitle(int colNum) {
        
        StringBuilder title = new StringBuilder();
        while (colNum > 0) {
            colNum--; // Adjust for zero-based indexing
            int remainder = colNum % 26;
            char letter = (char) ('A' + remainder);
            title.insert(0, letter); // Prepend the character
            colNum = colNum / 26;
        }
        return title.toString();
    }

    public static void main(String[] args) {
        
        System.out.println(convertToTitle(57));
    }
}