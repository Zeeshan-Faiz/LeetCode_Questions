package DynamicProgramming.MediumQuestions;

import java.util.ArrayList;
import java.util.List;

/*
You are given an array of words where each word consists of lowercase English letters.
wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in 
wordA without changing the order of the other characters to make it equal to wordB.
    For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".

A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a 
predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a 
word chain with k == 1.
Return the length of the longest possible word chain with words chosen from the given list of words.

Example 1:
Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chains is ["a","ba","bda","bdca"].

Example 2:
Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
Output: 5
Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].

Example 3:
Input: words = ["abcd","dbqca"]
Output: 1
Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.
*/

public class Q1048LongestStringChain {
    
     int maxLength;
    List<String>[] graph;

    public int longestStrChain(String[] words) {
        int length = 0;

        for (String word : words) {
            length = Math.max(length, word.length());
        }

        maxLength = 1;
        graph = new List[length + 1];

        for (int i = 0; i <= length; i++) {
            graph[i] = new ArrayList<String>();
        }

        for (String word : words) {
            graph[word.length()].add(word);
        }

        for (int k = 1; k < length; k++) {
            for (int i = 0; i < graph[k].size(); i++) {
                dfs(graph[k].get(i), k + 1, 1);
            }
        }
        return maxLength;
    }

 
    private boolean isGood(String word1, String word2) {

        int i = 0;
        int j = 0;
        int count = 0;

        while (count != 2 && i < word1.length()) {
            if (word1.charAt(i) == word2.charAt(j)) {
                i++;
                j++;
            }
            else {
                j++;
                count++;
            }
        }

        return count != 2;
    }

    private void dfs(String word, int k, int length) {

        if (k == graph.length) {
            return;
        }

        for (int i = 0; i < graph[k].size(); i++) {
            if (isGood(word, graph[k].get(i))) {
                maxLength = Math.max(maxLength, length + 1);
                dfs(graph[k].get(i), k + 1, length + 1);
                graph[k].remove(i--);
            }
        }
    }
}