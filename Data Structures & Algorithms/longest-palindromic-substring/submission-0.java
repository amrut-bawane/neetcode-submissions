class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
       int start = 0, end = 0;

       for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i+1);
            int currentLength = end - start + 1;

            int longer = Math.max(len1, len2);
            if (longer > currentLength) {
                if (longer == len1) {
                    start = i - (len1 - 1) / 2;
                    end = i + (len1 - 1) / 2;
                } else {
                    start = i - (len2 / 2 - 1);
                    end = i + 1 + (len2 / 2 - 1);
                }
            }
       }
        return s.substring(start, end + 1);
    }

    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
