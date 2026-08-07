class Solution {
    public int climbStairs(int n) {
        // int[] ways = new int[n+1];
        // for (int i=0; i<=n; i++) {
        //     ways[i] = -1;
        // }
        // return climb(n, ways);
        if (n <= 2) {
            return n;
        }
        int currentStep = 0;
        int oneStepBelow = 2;
        int twoStepsBelow = 1;

        for (int i=3; i<=n; i++) {
            currentStep = oneStepBelow + twoStepsBelow;
            twoStepsBelow = oneStepBelow;
            oneStepBelow = currentStep;
        }
        return currentStep;
    }

    private int climb(int n, int[] ways) {
        if (n == 0) return 1;
        if (ways[n] != -1) return ways[n];
        int ans = climb(n-1, ways);
        if (n-2>=0)
            ans += climb(n-2, ways);
        ways[n] = ans;
        return ans;
    }
}
