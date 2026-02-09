class Solution {
    public int longestValidParentheses(String s) {
        int l = s.length();
        int[] dp = new int[l];
        for (int i = 1; i < l; i++) {
            if (s.charAt(i) == ')') {
                // Case 1: Immediate match "()"
                // If previous char is '(', we found a pair. Add 2 + any valid length before
                // this pair.
                if (i - 1 >= 0 && s.charAt(i - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - 2 >= 0 ? dp[i - 2] : 0);
                }
                // Case 2: Nested match "))" like "(())"
                // If previous char is also ')', check the character before the valid substring
                // ending at i-1
                else {
                    int prev = i - dp[i - 1] - 1;
                    // We found a matching '(' for the current ')'.
                    // Add 2 (new pair) + dp[i-1] (inner length) + any valid length before the
                    // matching '('
                    if (prev >= 0 && s.charAt(prev) == '(') {
                        dp[i] = dp[i - 1] + 2 + (prev - 1 >= 0 ? dp[prev - 1] : 0);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < l; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}