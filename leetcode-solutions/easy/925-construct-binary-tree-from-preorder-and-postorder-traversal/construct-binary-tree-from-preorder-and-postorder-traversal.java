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
     private Map<Integer, Integer> postIndexMap;
    private int preIndex = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
   postIndexMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }
        return construct(preorder, postorder, 0, preorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int[] postorder, int left, int right) {
        if (left > right) return null;
        
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if (left == right) return root;

        int leftSubtreeIndex = postIndexMap.get(preorder[preIndex]);

        root.left = construct(preorder, postorder, left, leftSubtreeIndex);
        root.right = construct(preorder, postorder, leftSubtreeIndex + 1, right - 1);
        
        return root;
    }
}