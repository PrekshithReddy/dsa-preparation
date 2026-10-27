class Solution {
    public int maximumDifference(int[] nums) {
      int ans=-1;
      int diff=0;
      int leastvalue=nums[0];
      int n=nums.length;
      for(int j=1;j<n;j++)
      {
        if(leastvalue<nums[j])
        {
            diff=nums[j]-leastvalue;
            ans=Math.max(ans,diff);
        }
        else{
            leastvalue=nums[j];
        }
      }  
      return ans;
    }
}