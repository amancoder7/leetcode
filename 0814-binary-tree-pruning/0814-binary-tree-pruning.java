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
    boolean isonepresent(TreeNode node){
        if(node==null){
           return false;
        }

        if(node.val==1){
            return true;
        }
        return (isonepresent(node.left)||isonepresent(node.right));
    }
    public TreeNode pruneTree(TreeNode root) {
         if(root==null){
            return null;
         }
         if(!isonepresent(root.left)){
            root.left=null;
         }
         if(!isonepresent(root.right)){
           root.right=null;  
         }

         pruneTree(root.left);
         pruneTree(root.right);

         if(root.left==null && root.right==null && root.val==0){
             return null;
         }
         return root;
    }
}