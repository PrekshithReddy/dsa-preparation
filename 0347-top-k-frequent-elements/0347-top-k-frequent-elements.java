class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer,Integer> map=new HashMap<>();
        for(int num:nums)
        {
            if(map.containsKey(num))
            {
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }
        int[] ans=new int[k];
        for(int i=0;i<k;i++)
        {
            int maxFreq=-1;
            int element=-1;
            for(int key:map.keySet())
            {
                if(map.get(key)>maxFreq)
                {
                    maxFreq=map.get(key);
                    element=key;
                }
            }
            ans[i]=element;
            map.put(element,-1);
        }
        return ans;
    }
}