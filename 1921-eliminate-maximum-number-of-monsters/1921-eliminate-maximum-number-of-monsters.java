class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n=dist.length;
        int[] Arrivaltime=new int[n];

        for(int i=0;i<n;i++){
            Arrivaltime[i]=(dist[i]+speed[i]-1)/speed[i];
        }
         Arrays.sort(Arrivaltime);
        for(int min=0;min<n;min++){
            if(Arrivaltime[min]<=min){
                 return min;
            }
              
        }
        return n;
    }
}