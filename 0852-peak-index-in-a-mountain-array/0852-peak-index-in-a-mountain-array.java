class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 1;
        int end = arr.length - 2;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;   // return index
            }
            else if (arr[mid] > arr[mid - 1]) {
                start = mid + 1;   // go right
            }
            else {
                end = mid - 1;     // go left
            }
        }
        return -1;
    }
}