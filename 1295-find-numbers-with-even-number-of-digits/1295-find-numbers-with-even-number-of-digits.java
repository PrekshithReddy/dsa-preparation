class Solution {
    public int findNumbers(int[] nums) {
        int evenCount=0;
        for(int i=0;i<nums.length;i++)
        {
            int temp=nums[i];
            int digitCount=0;
            while(temp!=0)
            {
                temp=temp/10;
                digitCount++;
            }
            if(digitCount%2==0)
            {
                evenCount++;
            }
        }
        return evenCount;
    }
}