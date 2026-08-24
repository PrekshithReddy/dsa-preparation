class Solution {
    public double findMaxAverage(int[] nums, int k) {
       double ws=0;
       double maxSum=0;
       for(int i=0;i<k;i++)
       {
        ws+=nums[i];
       } 
       maxSum=ws;
       for(int i=k;i<nums.length;i++)
       {
        ws+=nums[i]-nums[i-k];
        maxSum=Math.max(maxSum,ws);
       }
       double average=maxSum/k;
       return average;
    }
}