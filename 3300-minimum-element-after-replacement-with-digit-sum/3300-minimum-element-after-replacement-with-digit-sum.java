class Solution {
    public int minElement(int[] nums) {
        int[] nums1=new int[nums.length];
        int Minsum=0;
        
        for(int i=0;i<nums.length;i++)
        {
            int num=nums[i];
            int sum=0;
            while(num!=0)
            {
                int digit=num%10;
                sum=sum+digit;
                num=num/10;
            }
            nums1[i]=sum;
        }
         Arrays.sort(nums1);
            Minsum=nums1[0];
        return Minsum;
    }
}