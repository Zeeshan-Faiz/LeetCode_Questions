import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a 
sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
    Every adjacent pair of words differs by a single letter.
    Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
    sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest 
transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. 
Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].

Example 1:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation: There are 2 shortest transformation sequences:
"hit" -> "hot" -> "dot" -> "dog" -> "cog"
"hit" -> "hot" -> "lot" -> "log" -> "cog"

Example 2:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: []
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
*/

public class Q126WordLadderII {

    List<List<String>> ans = new ArrayList<>();
    Map<String, Integer> wordToId = new HashMap<>();
    Map<Integer, String> idToWord = new HashMap<>();
    Map<Integer, List<Integer>> path = new HashMap<Integer, List<Integer>>();
    Deque<String> list = new LinkedList<>();
    int[] ne, e, h;
    boolean[] vis;
    int len, idx, start, end;

    void add(int u, int v) {
        e[++len] = v;
        ne[len] = h[u];
        h[u] = len;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        int n = wordList.size();
        ne = new int[20 * n];
        e = new int[20 * n];
        h = new int[20 * n];
        vis = new boolean[10 * n];
        if (!wordList.contains(beginWord))
            wordList.add(beginWord);
        if (!wordList.contains(endWord))
            return ans;
        for (int i = 0; i < wordList.size(); i++)
            addEdge(wordList.get(i));
        Queue<Integer> q = new LinkedList<>();
        start = wordToId.get(beginWord);
        end = wordToId.get(endWord);
        q.add(start);
        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == end)
                break;
            if (vis[u])
                continue;
            vis[u] = true;
            for (int j = h[u]; j != 0; j = ne[j]) {
                int v = e[j];
                if (vis[v])
                    continue;
                if (!path.containsKey(v))
                    path.put(v, new ArrayList<>());
                path.get(v).add(u);
                q.add(v);
            }
        }
        list.add(endWord);
        dfs(end, 0);
        return ans;
    }

    void dfs(int u, int level) {
        
        if (u == start) {
            ans.add(new ArrayList<>(list));
            return;
        }
        List<Integer> p = path.get(u);
        if (p == null)
            return;
        for (int i = 0; i < p.size(); i++) {
            int v = p.get(i);
            if (level % 2 == 1)
                list.addFirst(idToWord.get(v));
            dfs(v, level + 1);
            if (level % 2 == 1)
                list.pollFirst();
        }
    }

    void addEdge(String word) {
        
        int u = idx;
        char[] arr = word.toCharArray();
        wordToId.put(word, idx);
        idToWord.put(idx++, word);
        for (int i = 0; i < arr.length; i++) {
            char t = arr[i];
            arr[i] = '*';
            String vstr = new String(arr);
            if (!wordToId.containsKey(vstr)) {
                wordToId.put(vstr, idx);
                idToWord.put(idx++, vstr);
            }
            int v = wordToId.get(vstr);
            add(u, v);
            add(v, u);
            arr[i] = t;
        }
    }
}