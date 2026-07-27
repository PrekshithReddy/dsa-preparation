class Solution {
    public int longestConsecutive(int[] nums) {
      Arrays.sort(nums);
        if(nums.length==0)
        {
            return 0;
        }
      int maxSeq=1;
      int seq=1;
      for(int i=0;i<nums.length-1;i++)
      {

        if(nums[i]==nums[i+1])
      {
        continue;
      }
        if(nums[i]==nums[i+1]-1)
        {
            seq++;
        }
        else{
            seq=1;
        }
      maxSeq=Math.max(seq,maxSeq);
      } 
 return maxSeq;      
    }
}