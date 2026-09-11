class Solution {
    public int totalNumbers(int[] digits) {

        Set<Integer> set = new HashSet<>();

        int n = digits.length;

        for (int i = 0; i < n; i++) {

            // i = units digit
            if (digits[i] % 2 != 0) {
                continue;
            }

            for (int j = 0; j < n; j++) {

                // Cannot use same position twice
                if (i == j) {
                    continue;
                }

                for (int k = 0; k < n; k++) {

                    // k = hundreds digit
                    // Cannot be 0
                    // Cannot reuse i or j
                    if (digits[k] == 0 || k == i || k == j) {
                        continue;
                    }

                    int number = digits[k] * 100
                              + digits[j] * 10
                              + digits[i];

                    set.add(number);
                }
            }
        }

        return set.size();
    }
}