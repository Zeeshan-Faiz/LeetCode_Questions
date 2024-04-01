package Tree.MediumQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, imagine yourself standing on the right side of it, return the 
values of the nodes you can see ordered from top to bottom.

Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

Example 2:
Input: root = [1,null,3]
Output: [1,3]
*/

public class Q199BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();
        helper(root, result, 0);
        return result;
    }

    public void helper(TreeNode curr, List<Integer> result, int currDepth) {

        if (curr == null)
            return;

        if (currDepth == result.size()) {
            result.add(curr.val);

            helper(curr.right, result, currDepth + 1);
            helper(curr.left, result, currDepth + 1);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}