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
        loop(root, sb);
        return ans;
    }

    private void loop(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        int length = sb.length();

        // Append the current node's value to the path.
        sb.append(root.val);
        // If it's a leaf node, add the path to the result list.
        if (root.left == null && root.right == null) {
            ans.add(sb.toString());
        }
        sb.append("->");
        loop(root.left, sb);
        loop(root.right, sb);
        sb.setLength(length);
    }
}