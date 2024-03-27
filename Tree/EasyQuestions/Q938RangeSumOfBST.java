package Tree.EasyQuestions;

/*
Given the root node of a binary search tree and two integers low and high, return the sum of values
of all nodes with a value in the inclusive range [low, high].

Example 1:
Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
*/

public class Q938RangeSumOfBST {

    public int rangeSumBST(TreeNode root, int low, int high) {

        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (low <= root.val && high >= root.val) {
            sum += root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else if (low > root.val) {
            sum += rangeSumBST(root.right, low, high);
        } else if (high < root.val) {
            sum += rangeSumBST(root.left, low, high);
        }
        return sum;
    }
}