class Solution {
    public long largestPerimeter(int[] nums) {
        int n=nums.length;
        long perimeter=0;
        long remainingSidesSum=0;
        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            if(remainingSidesSum>nums[i]){
                   perimeter=remainingSidesSum+nums[i];
            }
            remainingSidesSum+=nums[i]; 
        }

        return perimeter==0 ? -1 :perimeter;

    }
}