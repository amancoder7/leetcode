class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
         int n=arr.length;
         HashMap<Integer,Integer>mp=new HashMap<>();
         for(int i=0;i<n;i++){
             mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);           
         }
        
        int[] arr1=new int[mp.size()];
            int i=0;
        for(Map.Entry<Integer,Integer>entry:mp.entrySet()){
                   arr1[i]=entry.getValue();
                   i+=1;     
        }
        Arrays.sort(arr1);
        i=0;
        int remove=0;
        while(i<arr1.length && k>0){
             if(k>=arr1[i]){
                k-=arr1[i];
                remove++;
             }
            i++;
        }

 return arr1.length-remove;


    }
}