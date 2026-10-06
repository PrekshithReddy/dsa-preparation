class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int x = i;
            int count = 0;

            while (x != 0) {
                x = x & (x - 1);
                count++;
            }

            ans[i] = count;
        }

        return ans;
    }
}