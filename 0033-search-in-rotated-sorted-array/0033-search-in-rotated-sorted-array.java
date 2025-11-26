class Solution {
    public int search(int[] nums, int target) {
       int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) return mid;

            // If left half [start..mid] is sorted
            if (nums[start] <= nums[mid]) {
                // If target lies in sorted left half
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // Right half [mid..end] must be sorted
            else {
                // If target lies in sorted right half
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
        
    }
}