class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        
        // Store key-value pairs in HashMap
        HashMap<String, String> map = new HashMap<>();

        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                // Find the closing bracket
                int j = i + 1;

                while (s.charAt(j) != ')') {
                    j++;
                }

                // Extract key
                String key = s.substring(i + 1, j);

                // Replace with value or ?
                result.append(map.getOrDefault(key, "?"));

                // Move i to closing bracket
                i = j;
            } 
            else {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}