class Solution {
    public boolean isMatch(String s, String p) {
        int si = 0, pi = 0, match = 0, star = -1;
        int sn = s.length(), pn = p.length();
        while (si < sn) {
            if (pi < pn && (p.charAt(pi) == '?' || p.charAt(pi) == s.charAt(si))) {
                si++;
                pi++;
            } else if (pi < pn && p.charAt(pi) == '*') {
                star = pi;
                match = si;
                pi++;
            } else if (star != -1) {
                pi = star + 1;
                match++;
                si = match;
            } else {
                return false;
            }
        }
        while (pi < pn && p.charAt(pi) == '*') {
            pi++;
        }
        return pi == pn;
    }
}