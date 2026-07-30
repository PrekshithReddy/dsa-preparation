class Solution {
    public int removeDuplicates(int[] nums) {
      int[] temp=new int[nums.length];
      int k=0;
      temp[k++]=nums[0];
      for(int i=1;i<nums.length;i++)
      {
        if(nums[i]!=nums[i-1])
            {
                temp[k++]=nums[i];
            }
          }  
        for(int i=0;i<nums.length;i++)
        {
            nums[i]=temp[i];
        }
        return k;
    }
}