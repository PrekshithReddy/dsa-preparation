class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int num:nums)
        {
            if(num%2==0)
            {
                hm.put(num,hm.getOrDefault(num,0)+1);
            }
        }
        int answer=-1;
        int maxFreq=0;
        for(int num:hm.keySet())
        {
            int frequency=hm.get(num);
            if(frequency>maxFreq)
            {
                maxFreq=frequency;
                answer=num;
            }
            if(frequency==maxFreq && num<answer)
            {
                answer=num;
            }
        }
        return answer;
    }
}