class Solution {
    public int[] replaceElements(int[] arr) {
        int n=arr.length;
        
        for(int i=0;i<n;i++)
        {
            int maxRight=0;
            for(int j=i+1;j<n;j++)
            {
                    maxRight=Math.max(maxRight,arr[j]);
                
            }
            arr[i]=maxRight;
        }
        arr[n-1]=-1;
        return arr;
    }
}