class Solution {
    public int maximumDifference(int[] nums) {
        int n=nums.length;
        int ans=-1;
        int diffi=0;
        int leastvalue=nums[0];
            for(int j=1;j<n;j++)
            {
                if(leastvalue<nums[j])
                {
                    diffi=nums[j]-leastvalue;
                    ans=Math.max(ans,diffi);
                }
                else{
                    leastvalue=nums[j];
                }
            }
        return ans;
   
    }
}
