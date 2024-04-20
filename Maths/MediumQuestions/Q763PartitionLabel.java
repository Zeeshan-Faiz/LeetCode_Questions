package Maths.MediumQuestions;

import java.util.LinkedList;
import java.util.List;

/*
You are given a string s. We want to partition the string into as many parts as possible so that 
each letter appears in at most one part. Note that the partition is done so that after 
concatenating all the parts in order, the resultant string should be s.
Return a list of integers representing the size of these parts.

Example 1:
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

Example 2:
Input: s = "eccbbbbdec"
Output: [10]
*/

public class Q763PartitionLabel {
    
    public List<Integer> partitionLabels(String s) {
        
         List<Integer> res = new LinkedList<>();
        char[] chars = s.toCharArray();
        //we use array as hashing to store 
        //the latest index of each chars
        int[] hash = new int[26];
        for(int i = 0; i < chars.length ; i++){
            hash[chars[i] - 'a'] = i;
        }
        //get the fathest index, initialize as -1
        int index = 0;
        int last = -1;
        for(int i = 0 ; i < chars.length ; i++){
            index = Math.max(index, hash[chars[i]-'a']);
            if(i == index){
                res.add(index-last);
                last=i;
            }
        }
        return res;
    }
}