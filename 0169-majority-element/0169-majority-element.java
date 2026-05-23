class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int answer=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:nums)
        {
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(int max:hm.keySet())
        {
            if(hm.get(max)>(n/2))
            {
                answer=max;
            }
        }
return answer;
    }
}