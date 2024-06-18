package Tree.EasyQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, the value of a target node target, and an integer k, return 
an array of the values of all nodes that have a distance k from the target node.
You can return the answer in any order.

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.

Example 2:
Input: root = [1], target = 1, k = 3
Output: []
*/

public class Q863AllNodesDistanceK {

    List<Integer> ans = new ArrayList<>();
    int k;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.k = k;
        find(root, target.val, 0);
        return ans;
    }

    int find(TreeNode root, int target, int depth) {
        
        if (root == null)
            return -1;

        if (root.val == target) {
            traverse(root, 0, k);
            return depth;
        }
        int foundDepth = find(root.left, target, depth + 1);
        if (foundDepth != -1) {
            if (foundDepth - depth == k) {
                ans.add(root.val);
            } else if (foundDepth - depth < k) {
                traverse(root.right, 1, k - (foundDepth - depth));
            }
            return foundDepth;
        }
        foundDepth = find(root.right, target, depth + 1);
        if (foundDepth != -1) {
            if (foundDepth - depth == k) {
                ans.add(root.val);
            } else if (foundDepth - depth < k) {
                traverse(root.left, 1, k - (foundDepth - depth));
            }
        }
        return foundDepth;
    }

    void traverse(TreeNode root, int depth, int targetDepth) {
        
        if (root == null)
            return;

        if (depth == targetDepth) {
            ans.add(root.val);
            return;
        }
        traverse(root.left, depth + 1, targetDepth);
        traverse(root.right, depth + 1, targetDepth);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}