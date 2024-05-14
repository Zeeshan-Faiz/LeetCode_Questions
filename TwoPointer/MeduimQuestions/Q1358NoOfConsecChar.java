package TwoPointer.MeduimQuestions;

/*
Given a string s consisting only of characters a, b and c.
Return the number of substrings containing at least one occurrence of all these characters a, b 
and c.

Example 1:
Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 

Example 2:
Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 

Example 3:
Input: s = "abc"
Output: 1
*/

public class Q1358NoOfConsecChar {

    public int numberOfSubstrings(String s) {

        int l = 0, r = 0, n = s.length();
        int ans = 0, hash[] = new int[3], count = 0;
        char[] arr = s.toCharArray();
        while (r < n) 
        {
            char ch = arr[r];
            hash[ch - 'a']++;
            if (hash[ch - 'a'] == 1)
                count++;
            while (count == 3) {
                ans += n - r;
                char rem = arr[l];
                int val = hash[rem - 'a'];
                if (val == 1) {
                    count--;
                }
                hash[rem - 'a']--;
                l++;
            }
            r++;
        }
        return ans;
    }
}