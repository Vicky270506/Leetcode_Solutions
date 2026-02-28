class Solution {

    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        // Base case
        if (node == null) {
            return 0;
        }

        // Get left subtree height
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;

        // Get right subtree height
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;

        // Check balance condition
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return height
        return Math.max(leftHeight, rightHeight) + 1;
    }
}