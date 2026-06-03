import java.util.Arrays;

class Solution {
    public int climbStairs(int n) {
        // 1. Initialize the DP array here once
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        
        // 2. Pass it into a helper method to handle the recursion
        return helper(n, dp);
    }
    
    private int helper(int n, int[] dp) {
        // Base cases
        if (n == 0 || n == 1) return 1;
        
        // Check if the answer is already stored
        if (dp[n] != -1) return dp[n];
        
        // Store the value in the array before returning it
        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
        
        return dp[n];
    }
}