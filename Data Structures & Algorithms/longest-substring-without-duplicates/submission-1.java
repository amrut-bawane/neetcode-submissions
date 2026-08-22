class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        // Index tracking last position of known character
        int[] charIndex = new int[128];
        Arrays.fill(charIndex, -1);
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            if (charIndex[curr] >= left) {
                // We've seen the char & it is inside our current window
                left = charIndex[curr] + 1;
            }

            // Entend right pointer. Update the position of the current char
            charIndex[curr] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
