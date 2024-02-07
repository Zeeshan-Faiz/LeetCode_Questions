package Strings.EasyQuestions;

/*
Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
A string is represented by an array if the array elements concatenated in order forms the string.

Example 1:
Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
Explanation:
word1 represents string "ab" + "c" -> "abc"
word2 represents string "a" + "bc" -> "abc"
The strings are the same, so return true.

Example 2:
Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
Output: false

Example 3:
Input: word1  = ["abc", "d", "defg"], w
*/

public class Q1662EquivalentStrings{

    static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        // Step 1: Initialize StringBuilder objects
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        // Step 2: Concatenate strings from the first array (word1) using a loop
        for (String str : word1) {
            sb1.append(str);
        }

        // Step 3: Concatenate strings from the second array (word2) using a loop
        for (String str : word2) {
            sb2.append(str);
        }

        // Step 4: Convert StringBuilder objects to strings
        String str1 = sb1.toString();
        String str2 = sb2.toString();

        // Step 5: Compare the strings using the equals method
        return str1.equals(str2);
    }

    public static void main(String[] args) {
        
        System.out.println(arrayStringsAreEqual(new String[] {"ab","c"}, new String[] {"a","bc"}));
    }
}