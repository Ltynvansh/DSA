class Solution {
    public int countPartitions(int[] nums) {

        int sumLeft = 0;
        int sumRight = Arrays.stream(nums).sum();
        int count = 0;

        // i must go only till n-2
        for (int i = 0; i < nums.length - 1; i++) {
            sumLeft += nums[i];
            sumRight -= nums[i];

            if ((sumRight - sumLeft) % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
