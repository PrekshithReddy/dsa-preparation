
import java.util.*;

class Solution {
    public int maxSelectedElements(int[] nums) {

        Arrays.sort(nums);

        HashMap<Integer, Integer> dp = new HashMap<>();

        int ans = 0;

        for (int x : nums) {

            int unchanged = dp.getOrDefault(x - 1, 0) + 1;

            int modified = dp.getOrDefault(x, 0) + 1;

            dp.put(x, Math.max(dp.getOrDefault(x, 0), unchanged));

            dp.put(x + 1, Math.max(dp.getOrDefault(x + 1, 0), modified));

            ans = Math.max(ans, Math.max(unchanged, modified));
        }

        return ans;
    }
}
