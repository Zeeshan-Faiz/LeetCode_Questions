package Tree.EasyQuestions;

/*
Given the root of a binary tree, return the sum of all left leaves.
A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
*/

public class Q404SumOfLeftNodes {

    int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //Adding only leaf node
        if (root.left != null && root.left.left == null && root.left.right == null) 
            ans += root.left.val;
        
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return ans;
    }
}