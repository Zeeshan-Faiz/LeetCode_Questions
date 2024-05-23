package Tree.EasyQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,2,3]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]
*/

public class Q144BinaryTreePreOrderTraversal {

    List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return result;
    }

    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        result.add(node.val);
        preOrder(node.left);
        preOrder(node.right);
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