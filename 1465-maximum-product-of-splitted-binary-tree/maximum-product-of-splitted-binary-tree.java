/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long c = Integer.MIN_VALUE;
    public int maxProduct(TreeNode root) {
        int total = findSum(root);
        long MOD = 1000000007;
        long ans = findMaxValue(root, total);
        return (int)(c%MOD);
    }
    private int findSum(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        return root.val + findSum(root.left) + findSum(root.right);
    }
    private long findMaxValue(TreeNode root, int t)
    {
        if(root==null)
        {
            return 0;
        }
        long s = findMaxValue(root.left, t) + root.val + findMaxValue(root.right, t);
        long othersum = t - s;
        c = Math.max(c, s*othersum);
        return s;
    }
}