package Tree.EasyQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, return all root-to-leaf paths in any order.
A leaf is a node with no children.

Example 1:
Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
*/

public class Q257BinaryTreePaths {

    List<String> ans = new ArrayList<String>();

    public List<String> binaryTreePaths(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return ans;
    }

    private void helper(TreeNode root, StringBuilder sb) {
        
        if (root == null)
            return;
        int length = sb.length();

        //append the current node's value to the path.
        sb.append(root.val);
        //if it's a leaf node, add the path to the result list.
        if (root.left == null && root.right == null) {
            ans.add(sb.toString());
        }
        //otherwise keep on adding the nodes
        sb.append("->");
        helper(root.left, sb);
        helper(root.right, sb);
        sb.setLength(length);//remove already added paths by reducing the length of sb
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