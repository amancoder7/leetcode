class Solution {
    public int maximumScore(int[] nums, int k) {
        int n=nums.length;
        int i=k;
        int j=k;
        int currmin=nums[k];
        int result=nums[k];
        while(j<n-1 ||i>0){
             int leftvalue=(i>0) ? nums[i-1] :0;
             int rightvalue=(j<n-1) ? nums[j+1] :0;
             if(leftvalue>rightvalue){
                i--;
                currmin=Math.min(currmin,nums[i]);
             }
             else{
                 j++;
                 currmin=Math.min(currmin,nums[j]);
             }
             result=Math.max(result,(j-i+1)*currmin);

        }
        return result;
    }
}