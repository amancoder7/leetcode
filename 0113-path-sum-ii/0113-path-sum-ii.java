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
     void path(TreeNode root,int targetSum,int sum ,List<List<Integer>>ans,List<Integer>list){
         if(root==null){
            return;
         }        
         list.add(root.val);
         sum+=root.val;

         if(root.left==null && root.right==null){
              if(targetSum==sum){
                   ans.add(new ArrayList<>(list));
              }
             list.remove(list.size()-1);
             return;
         }
         path(root.left,targetSum,sum,ans,list);
         path(root.right,targetSum,sum,ans,list);
         list.remove(list.size()-1);

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        List<Integer>list=new ArrayList<>();
        path(root,targetSum,0,ans,list);
        return ans;
    }
}