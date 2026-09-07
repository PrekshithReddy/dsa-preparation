class Solution {
    public int distinctSubseqII(String s) {
        final int MOD = 1_000_000_007;

        long[] dp = new long[26];

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';

            long total = 0;

            for (long x : dp) {
                total = (total + x) % MOD;
            }

            dp[idx] = (total + 1) % MOD;
        }

        long ans = 0;

        for (long x : dp) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }
}