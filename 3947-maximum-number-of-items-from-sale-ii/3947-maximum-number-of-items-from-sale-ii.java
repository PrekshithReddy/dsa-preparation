
import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;
        int maxFactor = 0;
        int minPrice = Integer.MAX_VALUE;

        // Find maximum factor and minimum price
        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
            minPrice = Math.min(minPrice, item[1]);
        }

        // Count how many items have each factor
        int[] freq = new int[maxFactor + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }

        // Count all factors that divide other item factors
        for (int i = 1; i <= maxFactor; i++) {
            for (int j = 2 * i; j <= maxFactor; j += i) {
                freq[i] += freq[j];
            }
        }

        // Sort items by price
        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));

        long remaining = budget;
        long answer = 0;

        // Buy items that give 2 items for the price of 1
        for (int[] item : items) {

            int factor = item[0];
            int price = item[1];

            // A bonus item costing >= 2 * minPrice
            // is not better than buying 2 cheapest items
            if (price >= 2L * minPrice) {
                break;
            }

            // Exclude the item itself
            int freeCount = freq[factor] - 1;

            if (freeCount <= 0) {
                continue;
            }

            // Number of bonus purchases we can afford
            long buy = Math.min(
                freeCount,
                remaining / price
            );

            answer += buy * 2;
            remaining -= buy * price;
        }

        // Buy normal items with remaining budget
        answer += remaining / minPrice;

        return (int) answer;
    }
}
