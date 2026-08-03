class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<numbers.length;i++)
        {
            int complement=target-numbers[i];
            if(hm.containsKey(complement))
            {
                return new int[]{hm.get(complement),i+1};
            }
            hm.put(numbers[i],i+1);
        }
        return new int[]{};
    }
}