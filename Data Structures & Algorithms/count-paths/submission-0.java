class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;

        // dp[j] = unique paths to reach current row's column j from (0, 0)
        int[] dp = new int[n];

        // Base case, row 0
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // dp[j] = Ways to reach prev row's j column (dp[j]) + curr row prev column (dp[j-1])
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n-1];
    }
}
