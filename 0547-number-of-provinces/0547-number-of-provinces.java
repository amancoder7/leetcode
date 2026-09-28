class Solution {
    void fun(int node,ArrayList<ArrayList<Integer>>adjLt,int []vis){
         vis[node]=1;
         for(Integer it:adjLt.get(node)){
              if(vis[it]==0){
                 fun(it,adjLt,vis);
              }
         }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>>adjLt=new ArrayList<>();
        int n=isConnected.length;
        int m=isConnected[0].length;
        for(int i=0;i<n;i++){
            adjLt.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjLt.get(i).add(j);
                    adjLt.get(j).add(i);
                }
            }
        }
        int vis[]=new int[adjLt.size()];
        int count=0;
        for(int i=0;i<adjLt.size();i++){
              if(vis[i]==0){
                 fun(i,adjLt,vis);
                 count++;
              }            
        }
        return count;
    }
}