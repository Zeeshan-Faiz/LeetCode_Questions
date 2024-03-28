package Tree.EasyQuestions;

/*
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the 
root node down to the farthest leaf node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3
*/

public class Q104MaxDepthOfBinaryTree {
    
    public int maxDepth(TreeNode root) {
        
        if(root == null)
            return 0;
    
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int depth = Math.max(left,right) + 1;

        return depth;
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