import java.util.*;

class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = nums[n - 1];

        // Check if last element equals n - 1
        if (max != n - 1) return false;

        // Check if all elements from 1 to n - 2 are unique and sequential
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != i + 1) return false;
        }

        // Check if last element (max) appears twice
        return nums[n - 1] == nums[n - 2];
    }
}
