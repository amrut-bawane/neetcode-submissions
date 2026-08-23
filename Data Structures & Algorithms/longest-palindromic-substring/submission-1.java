class Solution {
   public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        // dp[i][j] = longest palindrome length for string starting at i & ending at j
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLen = 1;
        int start = 0, end = 0;
        for (int i=0; i < s.length(); i++) {
            // Length 1
            dp[i][i] = true;

            // Length 2
            if (i < s.length() - 1) {
                if (s.charAt(i) == s.charAt(i+1)) {
                    dp[i][i+1] = true;
                    start = i;
                    end = i+1;
                    maxLen = 2;
                }
            }
        }

        for (int len = 3; len <= s.length(); len++) {
            for (int i=0; i<s.length() - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        start = i;
                        end = j;
                        maxLen = j - i + 1;
                    }
                }
            }
        }
    
        return s.substring(start, end+1);

    }

    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
