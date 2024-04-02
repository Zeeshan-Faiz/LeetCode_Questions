package Tree.MediumQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from 
left to right, then right to left for the next level and alternate between)

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
*/

public class Q103BinaryZigZagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return new ArrayList<>();

        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {

            int len = queue.size();
            List<Integer> ans = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null)
                    queue.add(temp.left);

                if (temp.right != null)
                    queue.add(temp.right);

                // cleverly add the nodes in the list for different levels in Zig-Zag order
                if (level % 2 == 0)
                    ans.add(temp.val);
                else
                    ans.add(0, temp.val);
            }
            level++;
            result.add(ans);
        }
        return result;
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