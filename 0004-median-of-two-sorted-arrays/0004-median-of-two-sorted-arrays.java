class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure we always binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;
        int low = 0;
        int high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            // Handle edges cases where the partition is at the extreme ends
            // If there is nothing on the left side, use MIN_VALUE
            // If there is nothing on the right side, use MAX_VALUE
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            // Check if we have found the correct partition
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // If total length is even
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } 
                // If total length is odd
                else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } 
            // We are too far on the right side of nums1. Go left.
            else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } 
            // We are too far on the left side of nums1. Go right.
            else {
                low = partitionX + 1;
            }
        }
        
        // Code should ideally never reach here if inputs are valid sorted arrays
        throw new IllegalArgumentException("Input arrays are not sorted or are invalid.");
    }
}