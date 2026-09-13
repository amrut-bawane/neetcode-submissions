class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) return List.of();

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSet = new ArrayList<>();
        // First in sorted order
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, currentSet, result);
        return result;
    }

    private void combinationSum(int[] candidates, int target, int currentIndex, List<Integer> currentSet, List<List<Integer>> result) {
        int n = candidates.length;
        if (target == 0) {
            // Found valid combination
            result.add(new ArrayList<>(currentSet));
            return;
        }
        if (currentIndex >= n || target < 0) return; // Guard
        
        for (int i = currentIndex; i < n; i++) {
            
            // Skip duplicate choices in the current tree so they don't get counted twice
            if (i > currentIndex && candidates[i] == candidates[i-1]) {
                continue;
            }
            if (candidates[i] > target) {
                // All remaining elems are larger. Exit early
                continue;
            }

            currentSet.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i+1, currentSet, result);
            currentSet.remove(currentSet.size() - 1);
        }        
    }
}
