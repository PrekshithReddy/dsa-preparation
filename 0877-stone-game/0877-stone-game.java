class Solution {
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        if(n%2==0)
        {
            return true;
        }
        else{
            return false;
        }
    }
}