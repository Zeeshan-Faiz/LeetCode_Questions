package Tree.EasyQuestions;

/*
Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the 
values of any two different nodes in the tree.

Example 1:
Input: root = [4,2,6,1,3]
Output: 1

Example 2:
Input: root = [1,0,48,null,null,12,49]
Output: 1
*/

public class Q530MinAbsoluteDifference {

    int res = Integer.MAX_VALUE;
    int prev = -1;//to store previous node value

    public int getMinimumDifference(TreeNode root) {
        
        if (root == null)
            return 0;
        //In-Order Traversal
        getMinimumDifference(root.left);
        if (prev != -1)
            res = Math.min(res, Math.abs(prev - root.val));
        
        prev = root.val;
        getMinimumDifference(root.right);

        return res;
    }
}