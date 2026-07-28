class Solution {
    public int partitionString(String s) {
        int[] lastseen=new int[26];
        Arrays.fill(lastseen,-1);
        int count=0;
        int curr_substring=0;
        int n=s.length();
        for(int i=0;i<n;i++){
             char ch=s.charAt(i);
            if(lastseen[ch-'a']>=curr_substring){
                count++;
                curr_substring=i;
            }
            lastseen[ch-'a']=i;
        }
        return count+1;
    }
}