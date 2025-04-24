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
     private int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
    
        dfs(root);
        return maxDiameter;
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = dfs(node.left);
        int rightDepth = dfs(node.right);

        // Update max diameter if path through root is larger
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        // Return the height of current node
        return Math.max(leftDepth, rightDepth) + 1;
    }
}