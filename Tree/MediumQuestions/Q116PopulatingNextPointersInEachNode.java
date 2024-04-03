package Tree.MediumQuestions;

/*
You are given a perfect binary tree where all leaves are on the same level, 
and every parent has two children.Populate each next pointer to point to its next right node. 
If there is no next right node, the next pointer should be set to NULL. Initially, all next 
pointers are set to NULL.

Example 1:
Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next 
pointer to point to its next right node, just like in Figure B. The serialized output is in level 
order as connected by the next pointers, with '#' signifying the end of each level.
*/

public class Q116PopulatingNextPointersInEachNode {

    public Node connect(Node root) {
        
        if (root == null)
            return null;

        Node leftMost = root;

        while (leftMost.left != null) {
            Node current = leftMost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}