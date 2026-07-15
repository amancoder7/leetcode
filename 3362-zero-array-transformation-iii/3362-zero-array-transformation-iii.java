class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n=nums.length;
        int Q=queries.length;
        PriorityQueue<Integer>Maxpq=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        PriorityQueue<Integer>past=new PriorityQueue<>((a,b)->Integer.compare(a,b));
        Arrays.sort(queries,(a,b)->Integer.compare(a[0],b[0]));
        
         int j=0;
         int count=0;

         for(int i=0;i<n;i++){
            while(j<Q && queries[j][0]==i){
                Maxpq.add(queries[j][1]);
                j++;
            }
           
            nums[i]-=past.size();

            while(nums[i]>0 && !Maxpq.isEmpty() && Maxpq.peek()>=i){
                  int element=Maxpq.peek();
                  Maxpq.poll();
                  past.add(element);
                  count++;
                  nums[i]--;
            }

            if(nums[i]>0){
                return -1;
            }

            while(!past.isEmpty() && past.peek()<=i){
                  past.poll();                
            }


         }

         return Q-count;
    }
}