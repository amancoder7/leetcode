class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->Integer.compare(b[1],a[1]));
        int sum=0;
        int n= boxTypes.length;
        int i=0; 
        while(truckSize>0 && i<n){
            if(boxTypes[i][0]<=truckSize){
               sum+= (boxTypes[i][0]* boxTypes[i][1]);
               truckSize-= boxTypes[i][0];  
            }
            else{
                sum+=(truckSize* boxTypes[i][1]);
                truckSize=0;
            }
            i++; 
        }
       return sum;
    }
}
