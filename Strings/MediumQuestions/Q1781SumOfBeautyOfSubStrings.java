package Strings.MediumQuestions;

/*
The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.
    For example, the beauty of "abaacc" is 3 - 1 = 2.
Given a string s, return the sum of beauty of all of its substrings.

Example 1:
Input: s = "aabcb"
Output: 5
Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.

Example 2:
Input: s = "aabcbaa"
Output: 17
*/

public class Q1781SumOfBeautyOfSubStrings {
    
    public int beautySum(String s) {
        int count = 0; // Initialize the total beauty sum

       for (int i = 0; i < s.length(); i++) {
           int[] freq = new int[26]; // Frequency array for each letter
           int max = 0; // Max frequency in the current substring
           int min = 0; // Min frequency in the current substring

           for (int j = i; j < s.length(); j++) {
               int code = s.charAt(j) - 'a'; // Convert character to index (0-25)
               freq[code]++; // Increment frequency of the current character

               max = Math.max(max, freq[code]); // Update max frequency
               
               // Check if the current character could affect the min frequency
               if (min >= freq[code] - 1) {
                   min = Integer.MAX_VALUE; // Reset min to max value for recalculation
                   for (int n : freq) {
                       // Update min to the smallest non-zero frequency
                       if (n > 0) min = Math.min(min, n);
                   }
               }
               // Calculate beauty for the current substring and add to total
               count += max - (min == Integer.MAX_VALUE ? 0 : min); // Adjust if min wasn't updated (empty substring)
           }
       }

       return count; // Return the total beauty sum
   }
}