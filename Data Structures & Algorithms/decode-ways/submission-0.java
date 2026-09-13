class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) return 0;
        int[] cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return numDecodings(s, 0, cache);
    }

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
