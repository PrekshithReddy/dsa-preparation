class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
        {
            return 0;
        }
        int count=1;
        int MaxCount=1;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1])
            {
                continue;
            }
            else if(nums[i]==nums[i+1]-1)
            {
                count++;
            }
            else{
                count=1;
            }
            MaxCount=Math.max(MaxCount,count);
        }
    return MaxCount;
    }

}