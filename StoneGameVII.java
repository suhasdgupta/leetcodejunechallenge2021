class StoneGameVII {
    Integer[][] memo;
    int[] preSum;
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        memo = new Integer[n][n];
        preSum = new int[n + 1];
        for (int i = 0; i < n; i++)
            preSum[i + 1] = preSum[i] + stones[i];
        return dp(0, n - 1);
    }
    int getSum(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
    int dp(int left, int right) {
        if (left > right) return 0;
        if (memo[left][right] != null) return memo[left][right];
        int scoreRemoveLeftMost = getSum(left + 1, right);
        int scoreRemoveRightMost = getSum(left, right - 1);
        int ans = Math.max(scoreRemoveLeftMost - dp(left + 1, right), scoreRemoveRightMost - dp(left, right - 1));
        return memo[left][right] = ans;
    }
}
