package Strings.MediumQuestions;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows 
like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Example 1:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
*/

public class Q6ZigZagConversion {

    public String convert(String s, int numRows) {
        
        int length = s.length();
        if (length == numRows || numRows == 1)
            return s;

        char[] ans = new char[length];
        int cnt = 0;
        for (int i = 0; i < numRows; i++) 
        {
            int j = i, k = 0, m = 2 * (numRows - 1);
            while (j < length)
            {
                ans[cnt++] = s.charAt(j);
                if (i == 0 || ((i + j) % m) != 0) 
                    k = (numRows - (i + 1)) * 2;
                else
                    k = 2 * i;
                    
                j = j + k;
            }
        }
        return new String(ans);
    }
}