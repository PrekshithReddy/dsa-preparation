class Solution {
    public int[] shuffle(int[] nums, int n) {
        int left=0;
        int right=n;
        int[] newNums=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            if(i%2==0)
            {
                newNums[i]=nums[left];
                left++;
            }
            else{
                newNums[i]=nums[right];
                right++;
            }
        }
        return newNums;
    }
}
