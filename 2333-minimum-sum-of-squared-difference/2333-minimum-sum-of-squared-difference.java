class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int n = nums1.length;
        int max = 0;

        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        long total = 0;
        for (int d : diff) {
            total += d;
        }

        if (total <= k) {
            return 0;
        }

        int[] freq = new int[max + 1];

        for (int d : diff) {
            freq[d]++;
        }

        for (int i = max; i > 0 && k > 0; i--) {
            if (freq[i] == 0) {
                continue;
            }

            int next = i - 1;
            long count = Math.min((long) freq[i], k);

            freq[i] -= (int) count;
            freq[next] += (int) count;
            k -= count;
        }

        long ans = 0;

        for (int i = 1; i <= max; i++) {
            ans += (long) i * i * freq[i];
        }

        return ans;
    }
}