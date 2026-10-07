import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                String current = queue.poll();

                // If current string is valid
                if (isValid(current)) {
                    result.add(current);
                    found = true;
                }

                // If we already found valid strings,
                // don't remove more characters
                if (found) {
                    continue;
                }

                // Remove one parenthesis at a time
                for (int i = 0; i < current.length(); i++) {

                    // Only remove '(' or ')'
                    if (current.charAt(i) != '(' &&
                        current.charAt(i) != ')') {
                        continue;
                    }

                    String next = current.substring(0, i)
                                 + current.substring(i + 1);

                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }

            // We found the minimum removals
            if (found) {
                break;
            }
        }

        return result;
    }

    // Checks whether parentheses are valid
    private boolean isValid(String s) {

        int count = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                count++;
            } 
            else if (ch == ')') {
                count--;

                // More ')' than '('
                if (count < 0) {
                    return false;
                }
            }
        }

        // All '(' must be closed
        return count == 0;
    }
}