class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        // If there is only one element
        if (n == 1) return nums[0];

        while (start < end) {
            int mid = start + (end - start) / 2;

            // Make mid even
            if (mid % 2 == 1) {
                mid--;
            }

            // Check pair (mid, mid+1)
            if (nums[mid] == nums[mid + 1]) {
                // Single element is to the right
                start = mid + 2;
            } else {
                // Single element is to the left or at mid
                end = mid;
            }
        }

        // start == end is the single element
        return nums[start];

    }
}