package Strings.EasyQuestions;

/*
Given two strings s and t, determine if they are isomorphic. Two strings s and t are isomorphic 
if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order 
of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:
Input: s = "egg", t = "add"
Output: true

Example 2:
Input: s = "foo", t = "bar"
Output: false

Example 3:
Input: s = "paper", t = "title"
Output: true
*/

public class Q205IsomorphicStrings {
    
    public boolean isIsomorphic(String s, String t) {
        int[] arr=new int[255];
       int[] arr2=new int[255];
       char[] ch=s.toCharArray();
       char[] ch1=t.toCharArray();
       for(int i=0;i<ch.length;i++)
       {
           if(arr2[ch1[i]]!=arr[ch[i]])
            return false;
           arr[ch[i]]=i+1;
           arr2[ch1[i]]=i+1;
       }
       return true;
    }
}