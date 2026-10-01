class Solution {
    void dfs(char[][] grid,int row,int col){
        grid[row][col]='0';
        if(row-1>=0 && grid[row-1][col]=='1'){
            dfs(grid,row-1,col);
        }
        if(col+1<grid[0].length && grid[row][col+1]=='1'){
            dfs(grid,row,col+1);
        }
        if(row+1<grid.length && grid[row+1][col]=='1'){
             dfs(grid,row+1,col);
        }
        if(col-1>=0 && grid[row][col-1]=='1'){
             dfs(grid,row,col-1);
        }
        
        }
    public int numIslands(char[][] grid) {
        ArrayList<ArrayList<Integer>>adjLt=new ArrayList<>();
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                     dfs(grid,i,j);
                     count++;
                }
            }
        }
        return count;

    }
}