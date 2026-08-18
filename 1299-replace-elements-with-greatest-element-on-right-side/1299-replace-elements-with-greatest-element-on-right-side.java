class Solution {
    public int[] replaceElements(int[] arr) {
        for(int i=0;i<arr.length;i++)
        {
            int maxRight=0;
            for(int j=i+1;j<arr.length;j++)
            {
                maxRight=Math.max(maxRight,arr[j]);
            }
            arr[i]=maxRight;
        }
        arr[arr.length-1]=-1;
        return arr;
    }
}