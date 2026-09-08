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
    int maxi=0;
    int find(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftsame=find(root.left);
        int rightsame=find(root.right);
        int leftpath=0;
        int rightpath=0;
        if( root.left!=null && root.val==root.left.val){
                leftpath=leftsame+1;
        }
         if(root.right!=null && root.val==root.right.val){
            rightpath=rightsame+1;
        }
        maxi=Math.max(maxi,leftpath+rightpath);
        return Math.max(leftpath,rightpath);
    }
    
    public int longestUnivaluePath(TreeNode root) {
        find(root);
        return maxi;
    }
}