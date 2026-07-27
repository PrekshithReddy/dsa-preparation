class Solution {
    public int findNumbers(int[] nums) {
        int n=nums.length;
        int EvenCount=0;
        for(int i=0;i<n;i++)
        {
            int count=0;
            int ele=nums[i];
            while(ele>0)
            {
                ele=ele/10;
                count++;
            }
            if(count%2==0)
            {
                EvenCount++;
            }
        }
        return EvenCount;
    }
}