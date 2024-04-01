package Tree.MediumQuestions;

/*
Given a binary tree root, a node X in the tree is named good if in the path from root to X there 
are no nodes with a value greater than X.
Return the number of good nodes in the binary tree.

Example 1:
Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.
*/

public class Q1448CountGoodNodes {
    
    public int goodNodes(TreeNode root) {
        return helper(root, Integer.MIN_VALUE);
    }

    private int helper(TreeNode root, int maxSoFar) {

        if (root == null)
            return 0;
        
        int isGoodNode = 0;
        
        if (root.val >= maxSoFar) {
            isGoodNode = 1;
            maxSoFar = root.val;
        }
        return helper(root.left, maxSoFar) + helper(root.right, maxSoFar) + isGoodNode;
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