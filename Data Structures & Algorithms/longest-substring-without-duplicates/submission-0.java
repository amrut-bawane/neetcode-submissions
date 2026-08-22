class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        Set<Character> charSet = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            if (charSet.contains(curr)) {
                // Shrink from left till the duplicate is gone
                // while (left <= right && s.charAt(left) != curr) {
                //     charSet.remove(s.charAt(left));
                //     left++;
                // }
                // // Now add the curr char. Pointers are corrected to the right positions
                // charSet.remove(s.charAt(left));
                // left++;


                while (charSet.contains(curr)) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
            }
            // Entend right pointer by including current
            charSet.add(curr);
            maxLength = Math.max(maxLength, charSet.size());
        }
        return maxLength;
    }
}
