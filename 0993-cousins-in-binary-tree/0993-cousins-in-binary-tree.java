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
     TreeNode x_parant=null;
     TreeNode y_parant=null;
     int x_depth=-1;
     int y_depth=-1;
     void check(TreeNode root,int x,int y,int depth,TreeNode parant){
        if(root==null){
            return;
        }

        if(root.val==x){
           x_parant=parant;
           x_depth=depth;
        }
        if(root.val==y){
            y_parant=parant;
            y_depth=depth;
        }
       check(root.left,x,y,depth+1,root);
       check(root.right,x,y,depth+1,root);
       return;

     }
    public boolean isCousins(TreeNode root, int x, int y) {
        check(root,x,y,1,root);
        if(x_parant.val!=y_parant.val && x_depth==y_depth){
             return true;
        }
        return false;
        
    }
}