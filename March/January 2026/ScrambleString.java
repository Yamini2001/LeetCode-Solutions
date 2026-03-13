import java.util.*;

class Solution {
    HashMap<String, Boolean> dp = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        return solve(s1, s2);
    }

    boolean solve(String s1, String s2) {
        // Base case: strings are identical
        if (s1.equals(s2))
            return true;

        String key = s1 + "#" + s2;
        if (dp.containsKey(key))
            return dp.get(key);

        int l = s1.length();

        // Pruning: Character frequency check
        int[] count = new int[26];
        for (int i = 0; i < l; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                dp.put(key, false);
                return false;
            }
        }

        // Try splitting at every possible index k
        for (int k = 1; k < l; k++) {
            // Case 1: No swap
            if (solve(s1.substring(0, k), s2.substring(0, k)) &&
                    solve(s1.substring(k), s2.substring(k))) {
                dp.put(key, true);
                return true;
            }

            // Case 2: Swap the two parts
            if (solve(s1.substring(0, k), s2.substring(l - k)) &&
                    solve(s1.substring(k), s2.substring(0, l - k))) {
                dp.put(key, true);
                return true;
            }
        }

        dp.put(key, false);
        return false;
    }
}