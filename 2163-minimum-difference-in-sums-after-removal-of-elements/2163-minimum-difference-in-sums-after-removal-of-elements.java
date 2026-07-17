class Solution {
    public long minimumDifference(int[] nums) {
        int N=nums.length;
        int n=N/3;
        long left_min[]=new long[N];
        long right_max[]=new long[N];
        
        long sum=0;

        PriorityQueue<Integer>pq_max=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        PriorityQueue<Integer>pq_min=new PriorityQueue<>();

        for(int i=0;i<2*n;i++){
            pq_max.add(nums[i]);
            sum+=nums[i];
            if(pq_max.size()>n){
                 sum-=pq_max.poll();
            }
            left_min[i]=sum;
        }
         sum=0;
        for(int i=3*n-1;i>=n;i--){
            pq_min.add(nums[i]);
            sum+=nums[i];
            if(pq_min.size()>n){
                 sum-=pq_min.poll();                                                               
            }
            right_max[i]=sum;
        }


        long result=Long.MAX_VALUE;
        for(int i=n-1;i<=2*n-1;i++){
             result=Math.min(result,left_min[i]-right_max[i+1]);
        }
        return result;

      


    }
}