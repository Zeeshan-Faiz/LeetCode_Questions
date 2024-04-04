package Tree.MediumQuestions;

import java.util.LinkedList;

/*
Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.
The width of one level is defined as the length between the end-nodes (the leftmost and rightmost 
non-null nodes), where the null nodes between the end-nodes that would be present in a complete 
binary tree extending down to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.

Example 1:
Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).

Example 2:
Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
*/

public class Q662MaximumWidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {

        LinkedList<pair> q = new LinkedList<>();
        int max = Integer.MIN_VALUE;

        if (root == null)
            return 0;

        q.addLast(new pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            // take the difference of the left and right indexes and add 1 to get the width.
            max = Math.max(max, (q.getLast().level - q.getFirst().level + 1));

            for (int i = 0; i < size; i++) {
                pair element = q.removeFirst();
                // The left child of root is given an index of (2* level)
                if (element.root.left != null)
                    q.addLast(new pair(element.root.left, 2 * element.level));

                // the right child is given an index of (2*level+1)
                if (element.root.right != null)
                    q.addLast(new pair(element.root.right, 2 * element.level + 1));
            }
        }
        return max;
    }
}