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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
     // Helper function to recursively remove target leaves
        root = remove(target, root);
        return root;
    }

    private TreeNode remove(int target, TreeNode node) {
        if (node == null) {
            return null;
        }
        
        // Recur on left and right subtrees
        node.left = remove(target, node.left);
        node.right = remove(target, node.right);
        
        // If the current node is a leaf and its value is equal to target, delete it
        if (node.left == null && node.right == null && node.val == target) {
            return null;
        }
        
        return node;
    }
}