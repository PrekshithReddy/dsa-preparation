import java.util.*;

class Solution {

    static class Interval {
        int start, end, weight, index;

        Interval(int start, int end, int weight, int index) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.index = index;
        }
    }

    static class State {
        long score;
        int[] indices;

        State(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        Interval[] arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        // Sort by start time
        Arrays.sort(arr, (a, b) -> {
            if (a.start != b.start)
                return Integer.compare(a.start, b.start);

            if (a.end != b.end)
                return Integer.compare(a.end, b.end);

            return Integer.compare(a.index, b.index);
        });

        /*
         * dp[i][k]:
         * Best answer starting from interval i
         * when we can still choose at most k intervals.
         */
        State[][] dp = new State[n + 1][5];

        // Base case
        for (int k = 0; k <= 4; k++) {
            dp[n][k] = new State(0, new int[0]);
        }

        for (int i = n - 1; i >= 0; i--) {

            // Cannot choose anything if k = 0
            dp[i][0] = new State(0, new int[0]);

            for (int k = 1; k <= 4; k++) {

                // -------------------------
                // OPTION 1: SKIP
                // -------------------------
                State skip = dp[i + 1][k];

                // -------------------------
                // OPTION 2: TAKE
                // -------------------------

                // Find first interval whose start > current end
                int next = findNext(arr, i + 1, arr[i].end);

                State afterTake = dp[next][k - 1];

                int size = afterTake.indices.length + 1;

                int[] takeIndices = new int[size];

                takeIndices[0] = arr[i].index;

                for (int j = 0; j < afterTake.indices.length; j++) {
                    takeIndices[j + 1] = afterTake.indices[j];
                }

                // Required answer is sorted by original index
                Arrays.sort(takeIndices);

                State take = new State(
                    arr[i].weight + afterTake.score,
                    takeIndices
                );

                // -------------------------
                // CHOOSE BETTER
                // -------------------------

                if (take.score > skip.score) {

                    dp[i][k] = take;

                } else if (take.score < skip.score) {

                    dp[i][k] = skip;

                } else {

                    // Same score:
                    // choose lexicographically smaller indices
                    if (compare(take.indices, skip.indices) < 0) {
                        dp[i][k] = take;
                    } else {
                        dp[i][k] = skip;
                    }
                }
            }
        }

        return dp[0][4].indices;
    }

    /*
     * Find the first interval whose start > currentEnd.
     *
     * IMPORTANT:
     * It must be >, not >=,
     * because intervals sharing an endpoint overlap.
     */
    private int findNext(
        Interval[] arr,
        int left,
        int currentEnd
    ) {

        int right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid].start > currentEnd) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /*
     * Lexicographical comparison.
     *
     * Returns:
     * -1 -> a is smaller
     *  0 -> equal
     *  1 -> b is smaller
     */
    private int compare(int[] a, int[] b) {

        int n = Math.min(a.length, b.length);

        for (int i = 0; i < n; i++) {

            if (a[i] < b[i]) {
                return -1;
            }

            if (a[i] > b[i]) {
                return 1;
            }
        }

        // If one is a prefix of the other,
        // shorter one is lexicographically smaller.
        if (a.length < b.length) {
            return -1;
        }

        if (a.length > b.length) {
            return 1;
        }

        return 0;
    }
}