package Strings.MediumQuestions;

/*
Given two version strings, version1 and version2, compare them. A version string consists of 
revisions separated by dots '.'. The value of the revision is its integer conversion ignoring 
leading zeros.
To compare version strings, compare their revision values in left-to-right order. If one of the 
version strings has fewer revisions, treat the missing revision values as 0.
Return the following:

    If version1 < version2, return -1.
    If version1 > version2, return 1.
    Otherwise, return 0.

Example 1:
Input: version1 = "1.2", version2 = "1.10"
Output: -1
Explanation: version1's second revision is "2" and version2's second revision is "10": 2 < 10, so version1 < version2.

Example 2:
Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".

Example 3:
Input: version1 = "1.0", version2 = "1.0.0.0"
Output: 0
Explanation: version1 has less revisions, which means every missing revision are treated as "0".
*/

public class Q165CompareVersionNumber {

    public int compareVersion(String v1, String v2) {
        
        int i = 0, j = 0;
        while (i < v1.length() || j < v2.length()) 
        {
            int n1 = 0, n2 = 0;
            while (i < v1.length() && v1.charAt(i) != '.') {
                n1 = n1 * 10 + (int) (v1.charAt(i) - '0');
                ++i;
            }
            while (j < v2.length() && v2.charAt(j) != '.') {
                n2 = n2 * 10 + (int) (v2.charAt(j) - '0');
                ++j;
            }

            if (n1 > n2)
                return 1;
            if (n1 < n2)
                return -1;

            ++i;
            ++j;
        }
        return 0;
    }
}