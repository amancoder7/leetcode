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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, postorder, 0, 0, preorder.length);
    }

    private TreeNode build(int[] preorder, int[] postorder,
                           int preStart, int postStart, int size) {

        // No node
        if (size == 0) {
            return null;
        }

        // Only one node
        TreeNode root = new TreeNode(preorder[preStart]);

        if (size == 1) {
            return root;
        }

        // preorder[preStart + 1] is left subtree root
        int leftRoot = preorder[preStart + 1];

        // Find leftRoot in postorder
        int index = postStart;

        while (postorder[index] != leftRoot) {
            index++;
        }

        // Number of nodes in left subtree
        int leftSize = index - postStart + 1;

        // Build left subtree
        root.left = build(
            preorder,
            postorder,
            preStart + 1,
            postStart,
            leftSize
        );

        // Build right subtree
        root.right = build(
            preorder,
            postorder,
            preStart + 1 + leftSize,
            index + 1,
            size - leftSize - 1
        );

        return root;
    }
}