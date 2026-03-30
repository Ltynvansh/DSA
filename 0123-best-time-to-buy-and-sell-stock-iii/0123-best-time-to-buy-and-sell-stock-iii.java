class Solution {

    public int helper(int index, int buy, int cap, int[] prices, int[][][] dp) {

        if (index == prices.length || cap == 0) return 0;

        if (dp[index][buy][cap] != -1) return dp[index][buy][cap];

        int profit = 0;

        if (buy == 1) {
            // Buy or skip
            int pick = -prices[index] + helper(index + 1, 0, cap, prices, dp);
            int notPick = helper(index + 1, 1, cap, prices, dp);
            profit = Math.max(pick, notPick);
        } else {
            // Sell or skip
            int pick = prices[index] + helper(index + 1, 1, cap - 1, prices, dp);
            int notPick = helper(index + 1, 0, cap, prices, dp);
            profit = Math.max(pick, notPick);
        }

        return dp[index][buy][cap] = profit;
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[][][] dp = new int[n][2][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return helper(0, 1, 2, prices, dp);
    }
}