package Tree.MediumQuestions;

/*
Given the root of a binary tree, flatten the tree into a "linked list":

    The "linked list" should use the same TreeNode class where the right child pointer points to 
    the next node in the list and the left child pointer is always null.
    The "linked list" should be in the same order as a pre-order traversal of the binary tree.

Example 1:
Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
*/

public class Q114FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        
        if (root == null)
            return;

        TreeNode current = root;
        while (current != null) {
            
            if (current.left != null) {
                TreeNode temp = current.left;
                // Find the rightmost null value for this current.left node
                while (temp.right != null) {
                    temp = temp.right;
                }

                // add all the left sub-tree to the right most node having null value to it's right
                temp.right = current.right;

                // add all the shifted nodes to right of the current node
                current.right = current.left;

                // make all the left side of the node as null
                current.left = null;
            }
            // move on to the next right node
            current = current.right;
        }
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