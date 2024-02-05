package Strings.EasyQuestions;

/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is 
not part of haystack.

Example 1:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
*/

public class Q28IndexOfFirstOccurence {

    static int strStr(String haystack, String needle) {
        
        int len = needle.length();
        for(int i = 0; i < haystack.length(); i++){
            if (len > haystack.length()) {
            return -1;
            }
            String substr = haystack.substring(i,len);
            if(substr.equals(needle)){
                return i;
            }
            len++;
        }
        return -1;
    }
 
    public static void main(String[] args) {
        
        System.out.println(strStr("sadbutsad", "sad"));
    }  
}
