class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n=capacity.length;
        int[] arr=new int[n];
        
        for(int i=0;i<n;i++){
            int current_capacity=capacity[i];
            int rock=rocks[i];

            int diff=current_capacity-rock;
            arr[i]=diff;
        }
       Arrays.sort(arr);
        int count=0;

        for(int i=0;i<n;i++){
            if(arr[i]==0){
                count++;
            }
            else{
                if(additionalRocks>=arr[i]){
                    additionalRocks-=arr[i];
                    count++;
                }
                else{
                    break;
                }
            }
        }
        return count;
    }
}