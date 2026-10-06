class Solution {
    public int singleNumber(int[] nums) {
        int xor=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            xor=xor^nums[i];
        }
        return xor;
    }
}