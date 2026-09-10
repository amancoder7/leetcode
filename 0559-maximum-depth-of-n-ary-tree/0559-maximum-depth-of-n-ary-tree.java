/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int maxDepth=0;
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        helper(root,1);
        return maxDepth;
         
    }
    void helper(Node root,int level){
         if(root==null){
            return;
         }       
         if(root.children.size()==0){
            maxDepth=Math.max(maxDepth,level);
         }
         List<Node>children=root.children;
         for(int i=0;i<children.size();i++){
             helper(children.get(i),level+1);
         }
    }
}