class Solution {
    public int findNumbers(int[] nums) {
        int EvenCount=0;
        for(int i=0;i<nums.length;i++)
        {
            int digitCount=0;
            int temp=nums[i];
            while(temp!=0)
            {
                temp=temp/10;
                digitCount++;
            }
            if(digitCount%2==0)
            {
                EvenCount++;
            }
        }
        return EvenCount;
    }
}