class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) return 0;
        int n = s.length();

        // dp[i] = num of ways to decode substring s(i)...s(end)
        int[] dp = new int[n+1];
        
        // Base case
        dp[n] = 1;

        for (int i = n-1; i>=0; i--) {
            if (s.charAt(i) == '0') {
                // Cannot be decoded strictly starting from this position
                dp[i] = 0;
                continue;
            }
            // Decode single char
            int ways = dp[i+1];
            if (i + 1 < n && Integer.parseInt(s.substring(i, i+2)) <= 26) {
                // Decode two chars & ways to decode remaining string.
                ways += dp[i+2];
            }
            dp[i] = ways;
        }
        return dp[0];
    }
    // public int numDecodings(String s) {
    //     if (s == null || s.isEmpty()) return 0;
    //     int[] cache = new int[s.length()];
    //     Arrays.fill(cache, -1);
    //     return numDecodings(s, 0, cache);
    // }

    private int numDecodings(String s, int start, int[] cache) {
        int n = s.length();

        // Base case
        if (start == n) return 1;

        // Can include current char?
        if (s.charAt(start) == '0') {
            return 0;
        }

        if (cache[start] != -1) {
            return cache[start];
        }

        // Include single char -> always possible
        int ways = numDecodings(s, start + 1, cache);

        // Try combination of two chars
        if (start < n-1 && Integer.parseInt(s.substring(start, start + 2)) < 27) {
            ways += numDecodings(s, start + 2, cache);
        }
        cache[start] = ways;
        return ways;

    }
}
