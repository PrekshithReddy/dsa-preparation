class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int num:nums)
        {
            if(hm.containsKey(num))
            {
                hm.put(num,hm.get(num)+1);
            }
            else{
                hm.put(num,1);
            }
        }
        int[] ans=new int[k];
        for(int i=0;i<k;i++)
        {
            int maxFreq=-1;
            int ele=-1;
            for(int key:hm.keySet())
            {
                if(hm.get(key)>maxFreq)
                {
                    maxFreq=hm.get(key);
                    ele=key;
                }
            }
            ans[i]=ele;
            hm.put(ele,-1);
        }
        return ans;
        }
    }
