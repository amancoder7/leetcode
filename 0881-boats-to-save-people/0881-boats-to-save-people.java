class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n=people.length;
        int i=0;
        int j=n-1;
        int min_boat=0;
        while(i<=j){
          if(people[i]+people[j]<=limit){
             i++;
             j--;
             min_boat+=1;
          }           
          else{
            j--;
            min_boat+=1;
          }              
        }
        return min_boat;
    }
}