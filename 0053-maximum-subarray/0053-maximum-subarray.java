class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int currSum=nums[0],maxSum=nums[0];
        for(int i=1;i<n;i++)
        {
            int temp=currSum+nums[i];
            currSum=Math.max(temp,nums[i]);
            maxSum=Math.max(currSum,maxSum);
        }
        return maxSum;
    }
}