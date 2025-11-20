class Solution {
    public int maxSubArray(int[] nums) {
        
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            // add current element to running sum
            currentSum += nums[i];

            // update best found so far
            maxSum = Math.max(maxSum, currentSum);

            // if running sum goes negative, reset it
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
        
    }
}