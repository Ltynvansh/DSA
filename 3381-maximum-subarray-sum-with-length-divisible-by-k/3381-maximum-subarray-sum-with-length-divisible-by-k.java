class Solution {
    public long maxSubarraySum(int[] nums, int k) {
       int n = nums.length;
        // minPrefix[m] will store the minimum prefix sum P[l] seen so far
        // for indices l such that l % k == m
        long[] minPrefix = new long[k];
        for (int i = 0; i < k; i++) minPrefix[i] = Long.MAX_VALUE;

        long prefix = 0L;
        // P[0] = 0 at index 0 (0 % k == 0)
        minPrefix[0] = 0L;

        long ans = Long.MIN_VALUE;

        // iterate r from 1..n, compute P[r] and use it
        for (int r = 1; r <= n; r++) {
            prefix += nums[r - 1];          // this is P[r]
            int mod = r % k;                // class we must match
            if (minPrefix[mod] != Long.MAX_VALUE) {
                ans = Math.max(ans, prefix - minPrefix[mod]);
            }
            // then include this prefix P[r] for future r' > r
            if (prefix < minPrefix[mod]) {
                minPrefix[mod] = prefix;
            }
        }

        return ans;

        
    }
}