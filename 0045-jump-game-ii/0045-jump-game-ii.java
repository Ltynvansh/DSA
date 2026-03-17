import java.util.*;

class Solution {

    int[] dp;

    public int solve(int[] nums, int currentIndex) {

        if (currentIndex >= nums.length - 1) {
            return 0;
        }

        if (dp[currentIndex] != -1) {
            return dp[currentIndex];
        }

        int minJumps = nums.length + 1;

        for (int step = nums[currentIndex]; step >= 1; step--) {

            if (currentIndex + step < nums.length) {

                int jumps = 1 + solve(nums, currentIndex + step);

                minJumps = Math.min(minJumps, jumps);
            }
        }

        return dp[currentIndex] = minJumps;
    }

    public int jump(int[] nums) {

        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return solve(nums, 0);
    }
}