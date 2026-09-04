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
     void solve(TreeNode root,StringBuilder sc){
        if(root==null){
            return;
        }          
       sc.append(root.val);
       if(root.left!=null || root.right!=null){
            sc.append('(');
            solve(root.left,sc);
            sc.append(')');
       }       
      if(root.right!=null){
         sc.append('(');
         solve(root.right,sc);
         sc.append(')');
      }
     }

    public String tree2str(TreeNode root) {
        StringBuilder sc=new StringBuilder();
         solve(root,sc);
         return sc.toString();
    }
}