class Solution {
    public int minimumRounds(int[] tasks) {
        int n=tasks.length;
        Map<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(tasks[i],mp.getOrDefault(tasks[i],0)+1);            
        }
        int count=0;
        for(Map.Entry<Integer,Integer>entry:mp.entrySet()){
             if(entry.getValue()==1){
                 return -1;
             }

             if(entry.getValue()%3==0){
                 count+=entry.getValue()/3;
             }
             else{
                count+=(entry.getValue()/3)+1;
             }
        }
        return count;
    }
}