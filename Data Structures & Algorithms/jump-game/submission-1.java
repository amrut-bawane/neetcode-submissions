class Solution {
    // // Time = O(n^2), Space = O(n)
    // public boolean canJump(int[] nums) {
    //     if (nums == null || nums.length == 0) return false;
    //     int[] results = new int[nums.length];
    //     return canJump(nums, 0, results);
    // }

    // Time = O(n), Space = O(1)
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        int maxReach = 0;
        for (int pos = 0; pos < nums.length; pos++) {
            if (pos > maxReach) return false;

            maxReach = Math.max(maxReach, nums[pos] + pos);

            if (maxReach >= nums.length - 1) return true;
        }
        return true;
    }

    // Can jump from position pos to end given a cached results array if prior solution exists
    // results[i] == 1 => can jump, 2 => cannot jump, 0 => unknown
    private boolean canJump(int[] nums, int pos, int[] results) {
        int n = nums.length;
        if (pos >= n-1) {
            // Reached the end
            return true;
        }
        if (results[pos] != 0) {
            return results[pos] == 1;
        }
        for (int nextPos = pos+1; nextPos <= Math.min(n-1, pos + nums[pos]); nextPos++) {
            if (canJump(nums, nextPos, results)) {
                results[pos] = 1;
                return true;
            }
        }
        results[pos] = 2;
        return false;
    }
}
