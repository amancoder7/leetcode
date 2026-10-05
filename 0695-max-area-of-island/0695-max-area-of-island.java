class Solution {
   int fun(int i,int j,int[][] grid){
    int n=grid.length;
    int m=grid[0].length;
      int row[]={-1,0,+1,0};
      int col[]={0,+1,0,-1};
      int area=1;
      for(int dir=0;dir<4;dir++){
          int dr_row=i+row[dir];
          int dr_col=j+col[dir];
          if(dr_row<n && dr_row>=0 && dr_col<m && dr_col>=0 && grid[dr_row][dr_col]==1){
              grid[dr_row][dr_col]=0;
             area+=fun(dr_row,dr_col,grid);
          }
   }
   return area;
   }
    public int maxAreaOfIsland(int[][] grid) {
         int n=grid.length;
         int m=grid[0].length;
         int maxi=0;
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    int ans=fun(i,j,grid);
                     maxi=Math.max(maxi,ans);
                }
            }
         }
         return maxi;

    }
}