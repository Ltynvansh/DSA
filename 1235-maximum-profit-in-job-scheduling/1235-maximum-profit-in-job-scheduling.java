import java.util.*;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        // Step 1: Create jobs array
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        // Step 2: Sort by start time
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // Extract start times for binary search
        int[] starts = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = jobs[i][0];
        }

        // DP array
        int[] dp = new int[n];

        return solve(0, jobs, starts, dp);
    }

    private int solve(int i, int[][] jobs, int[] starts, int[] dp) {
        if (i >= jobs.length) return 0;

        if (dp[i] != 0) return dp[i];

        // Option 1: skip
        int skip = solve(i + 1, jobs, starts, dp);

        // Option 2: take
        int nextIndex = binarySearch(starts, jobs[i][1]);
        int take = jobs[i][2] + solve(nextIndex, jobs, starts, dp);

        return dp[i] = Math.max(skip, take);
    }

    private int binarySearch(int[] starts, int target) {
        int left = 0, right = starts.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (starts[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }
}