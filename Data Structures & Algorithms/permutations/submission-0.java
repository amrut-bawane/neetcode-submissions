class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        int n = nums.length;
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> permutations = new ArrayList<>();

        boolean[] used = new boolean[n];
        backtrack(nums, current, used, permutations);

        return permutations;
    }

    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> permutations) {
        if (current.size() == nums.length) {
            // Record permutation & return
            permutations.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            current.add(nums[i]);
            used[i] = true;
            
            backtrack(nums, current, used, permutations);
            
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
