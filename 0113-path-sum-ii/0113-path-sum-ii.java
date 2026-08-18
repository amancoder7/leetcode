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
    List<List<Integer>>ans=new ArrayList<>();
    int sum=0;
       void fillNode(TreeNode root, int targetSum,List<Integer>temp){
        if(root==null){
             return;
        }
        sum+=root.val;
        temp.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==targetSum){
                ans.add(new ArrayList<>(temp));
            }
             sum-=root.val;
             temp.remove(temp.size()-1);
            return;
        }
         fillNode(root.left, targetSum, temp);
         fillNode(root.right, targetSum, temp);
          sum-=root.val;
             temp.remove(temp.size()-1);
         return;
      }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer>temp=new ArrayList<>();
        sum=0;
       fillNode(root,targetSum,temp);
       return ans;
    }
}