import java.util.*;

class Solution {
    public int passwordStrength(String password) {
        Set<Character> seen = new HashSet<>();
        int strength = 0;

        for (char ch : password.toCharArray()) {
            if (seen.contains(ch)) continue; 
            seen.add(ch);

            if (ch >= 'a' && ch <= 'z') {
                strength += 1;
            } else if (ch >= 'A' && ch <= 'Z') {
                strength += 2;
            } else if (ch >= '0' && ch <= '9') {
                strength += 3;
            } else if ("!@#$".indexOf(ch) != -1) { 
                strength += 5;
            }
        }
        return strength;
    }
}
