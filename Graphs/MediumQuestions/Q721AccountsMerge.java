package Graphs.MediumQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given a list of accounts where each element accounts[i] is a list of strings, where the first 
element accounts[i][0] is a name, and the rest of the elements are emails representing emails of 
the account.
Now, we would like to merge these accounts. Two accounts definitely belong to the same person if 
there is some common email to both accounts. Note that even if two accounts have the same name, 
they may belong to different people as people could have the same name. A person can have any 
number of accounts initially, but all of their accounts definitely have the same name.
After merging the accounts, return the accounts in the following format: the first element of 
each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

Example 1:
Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Explanation:
The first and second John's are the same person as they have the common email "johnsmith@mail.com".
The third John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.

Example 2:

Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
*/

public class Q721AccountsMerge {

    Set<String> visited = new HashSet<>();
    HashMap<String, List<String>> adjList = new HashMap<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        // create the graph the from accounts
        for (List<String> account : accounts) {
            // get(1) bcz 0 index is name
            String firstEmail = account.get(1);
            int accountSize = account.size();
            for (int index = 2; index < accountSize; index++) {
                String email = account.get(index);
                if (!adjList.containsKey(firstEmail)) {
                    adjList.put(firstEmail, new ArrayList<String>());
                }
                adjList.get(firstEmail).add(email);
                if (!adjList.containsKey(email)) {
                    adjList.put(email, new ArrayList<String>());
                }
                adjList.get(email).add(firstEmail);
            }
        }
        // DFS from all the nodes
        List<List<String>> res = new ArrayList<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            // firstEmail
            String firstEmail = account.get(1);

            if (!visited.contains(firstEmail)) {
                ArrayList<String> mergeAccount = new ArrayList<>();
                mergeAccount.add(name);
                DFS(mergeAccount, firstEmail);
                Collections.sort(mergeAccount.subList(1, mergeAccount.size()));
                res.add(mergeAccount);
            }

        }
        return res;
    }

    public void DFS(List<String> mergeAccount, String email) {
        
        visited.add(email);
        mergeAccount.add(email);

        if (!adjList.containsKey(email))
            return;

        for (String neighbour : adjList.get(email)) {
            if (!visited.contains(neighbour)) {
                DFS(mergeAccount, neighbour);
            }
        }
    }
}