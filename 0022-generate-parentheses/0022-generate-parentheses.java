class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(result, "", 0, 0, n);

        return result;
    }

    public void backtrack(List<String> result, String str,
                          int open, int close, int n) {

        // Base case
        if (str.length() == 2 * n) {
            result.add(str);
            return;
        }

        // Add opening bracket
        if (open < n) {
            backtrack(result, str + "(", open + 1, close, n);
        }

        // Add closing bracket
        if (close < open) {
            backtrack(result, str + ")", open, close + 1, n);
        }
    }
}