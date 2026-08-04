class Solution {
    public boolean winnerOfGame(String colors) {
        int n=colors.length();
        int countofAlice=0;
        int countofBob=0;
        for(int i=1;i<n-1;i++){
            if(colors.charAt(i)==colors.charAt(i-1) && colors.charAt(i)==colors.charAt(i+1)){
                if(colors.charAt(i)=='A'){
                    countofAlice++;
                }
                else{
                     countofBob++;
                }
            }
        }
       
      return countofAlice>countofBob;

    }
}