class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n=colors.length();
        int time =0;
        int maxprev=0;
        
        for(int i=0;i<n;i++){
            if(i>0 && colors.charAt(i)!=colors.charAt(i-1)){
                maxprev=0;
            }

            int curr=neededTime[i];
            time+=Math.min(maxprev,curr);
            maxprev=Math.max(maxprev,curr);
        }
        return time;
    }
}