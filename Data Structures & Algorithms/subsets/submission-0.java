class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> currentSubset, int currentIndex) {
        if (currentIndex == nums.length) {
            result.add(new ArrayList<>(currentSubset));
            return;
        };

        // Option 1: Include current item in current subset
        currentSubset.add(nums[currentIndex]);
        backtrack(nums, result, currentSubset, currentIndex + 1);
        currentSubset.remove(currentSubset.size() - 1);


        // Option 2: Exclude current item from prev subsets
        backtrack(nums, result, currentSubset, currentIndex + 1);
    }
}
