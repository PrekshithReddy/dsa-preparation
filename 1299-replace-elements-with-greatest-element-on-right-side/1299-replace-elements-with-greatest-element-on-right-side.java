class Solution {
    public int[] replaceElements(int[] arr) {
        for(int i=0;i<arr.length;i++)
        {
            int greatest=0;
            for(int j=i+1;j<arr.length;j++)
            {
                
                greatest=Math.max(greatest,arr[j]);
            }
            arr[i]=greatest;
            }

        
        arr[arr.length-1]=-1;
        return arr;
    }
}