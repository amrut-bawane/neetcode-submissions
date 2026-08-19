class Solution {
     public List<List<Integer>> combinationSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> results = new ArrayList<>();
        combinations(nums, target, new ArrayList<>(), 0, 0, results);
        return results;
    }

    private void combinations(int[]nums, int target, List<Integer> currentSubset, int currentIndex, 
                                int currentSum, List<List<Integer>> results) {
        // Base case
        if (target == currentSum) {
            results.add(new ArrayList<>(currentSubset));
            return;
        }
        if (currentSum > target || currentIndex >= nums.length) return;

        // Include the current number. Probe again possibly including the current number
        currentSubset.add(nums[currentIndex]);
        combinations(nums, target, currentSubset, currentIndex, currentSum+nums[currentIndex], results);
        currentSubset.remove(currentSubset.size() - 1);

        // Skip the current number
        combinations(nums, target, currentSubset, currentIndex+1, currentSum, results);
    }
}
