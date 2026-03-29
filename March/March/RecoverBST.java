import java.util.TreeSet;

class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        helper(root);
        // Swap the values of the two misplaced nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    void helper(TreeNode node) {
        if (node == null)
            return;

        // Traverse left subtree
        helper(node.left);

        // Detect swapped nodes
        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }

        prev = node;

        // Traverse right subtree
        helper(node.right);
    }
}