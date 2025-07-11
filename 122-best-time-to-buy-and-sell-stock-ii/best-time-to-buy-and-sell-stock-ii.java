class Solution {
    private int[][] dp;

    private int solve(int index, boolean buy, int[] prices, int n) {
        if (index == n) {
            return 0;
        }
        int buyIndex = buy ? 1 : 0;
        if (dp[index][buyIndex] != -1) {
            return dp[index][buyIndex];
        }

        int profit = 0;
        if (buy) {
            int pick = -prices[index] + solve(index + 1, false, prices, n);
            int notPick = solve(index + 1, true, prices, n);
            profit = Math.max(pick, notPick);
        } else {
            int pick = prices[index] + solve(index + 1, true, prices, n);
            int notPick = solve(index + 1, false, prices, n);
            profit = Math.max(pick, notPick);
        }

        dp[index][buyIndex] = profit;
        return profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2]; // 2 states: buy or not buy
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(0, true, prices, n);
    }
}