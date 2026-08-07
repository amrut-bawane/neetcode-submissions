class Solution {
    public int maxSubArray(int[] nums) {
        int maxSumTillNow = nums[0], currentSum = nums[0];
        for (int i = 1; i< nums.length; i++) {
            // Include current elem in the max sum subarray?
            if (nums[i] + currentSum > nums[i]) {
                currentSum = nums[i] + currentSum;
            } else {
                currentSum = nums[i];
            }
            maxSumTillNow = Math.max(maxSumTillNow, currentSum);
        }
        return maxSumTillNow;
    }
}
