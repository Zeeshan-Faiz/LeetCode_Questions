package Tree.MediumQuestions;

/*
Given the root of a binary search tree, and an integer k, return the kth smallest value 
(1-indexed) of all the values of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
*/

public class Q230KthSmallestElementInBST {

    int count = 0;
    int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return ans;
    }

    public void inOrder(TreeNode root, int k) {
        
        if (root == null)
            return;
        
        inOrder(root.left, k);
        count++;
        if (k == count) {
            ans = root.val;
            return;
        }
        inOrder(root.right, k);
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