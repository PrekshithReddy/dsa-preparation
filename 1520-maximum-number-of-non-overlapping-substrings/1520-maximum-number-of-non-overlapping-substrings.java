class Solution {

    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        // Initialize
        for (int i = 0; i < 26; i++) {
            first[i] = n;
            last[i] = -1;
        }

        // Find first and last occurrence
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';

            first[index] = Math.min(first[index], i);
            last[index] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // Create valid intervals
        for (int i = 0; i < n; i++) {

            int ch = s.charAt(i) - 'a';

            // Only start from first occurrence
            if (i != first[ch]) {
                continue;
            }

            int left = i;
            int right = last[ch];

            boolean valid = true;

            int j = left;

            while (j <= right) {

                int current = s.charAt(j) - 'a';

                // This character appeared before our starting point
                if (first[current] < left) {
                    valid = false;
                    break;
                }

                // Expand interval
                right = Math.max(right, last[current]);

                j++;
            }

            if (valid) {
                intervals.add(new int[]{left, right});
            }
        }

        // Sort by ending position
        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        List<String> ans = new ArrayList<>();

        int previousEnd = -1;

        for (int[] interval : intervals) {

            int left = interval[0];
            int right = interval[1];

            // Non-overlapping
            if (left > previousEnd) {

                ans.add(s.substring(left, right + 1));

                previousEnd = right;
            }
        }

        return ans;
    }
}