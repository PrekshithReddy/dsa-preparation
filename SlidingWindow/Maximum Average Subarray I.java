// Problem: Maximum Average Subarray I
// Platform: LeetCode
// Approach: Sliding Window
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public double findMaxAverage(int[] nums, int k) {
       double Average=0;
       double maxSum=0;
        double windowSum=0;
        for(int i=0;i<k;i++){
            windowSum=windowSum+nums[i];
        }
        maxSum=windowSum;
        for(int i=k;i<nums.length;i++){
            windowSum=windowSum+nums[i];
            windowSum=windowSum-nums[i-k];
            maxSum=Math.max(windowSum,maxSum);
        }
        Average=maxSum/k;
 return Average;
    }
    
}
