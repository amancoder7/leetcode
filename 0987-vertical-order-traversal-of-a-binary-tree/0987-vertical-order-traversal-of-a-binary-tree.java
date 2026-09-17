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
 class Tuple{
     TreeNode node;
     int row;
     int col;
     public Tuple(TreeNode _node,int _row,int _col){
        this.node=_node;
        this.row=_row;
        this.col=_col;
     }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>mp=new TreeMap<>();
        Queue<Tuple>q=new LinkedList<Tuple>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
           Tuple tuple=q.poll();
           TreeNode node=tuple.node;
           int x=tuple.row;
           int y=tuple.col;

           if(!mp.containsKey(x)){
              mp.put(x,new TreeMap<>());
           }

           if(!mp.get(x).containsKey(y)){
              mp.get(x).put(y,new PriorityQueue<>());
           }
           mp.get(x).get(y).offer(node.val);
           if(node.left!=null){
             q.offer(new Tuple(node.left,x-1,y+1));
           }
           if(node.right!=null){
            q.offer(new Tuple(node.right,x+1,y+1));
           }
        }
        List<List<Integer>>list=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>>ys:mp.values()){
             List<Integer>ans=new ArrayList<>();
            for(PriorityQueue<Integer>nodes:ys.values()){
                  while(!nodes.isEmpty()){
                       ans.add(nodes.poll());
                  }
            }
              list.add(ans);
        }
        return list;

    }
}