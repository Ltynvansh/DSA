class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long total = 0;
        for (int b : batteries) total += b;

        long low = 0, high = total / n;

        while (low < high) {
            long mid = (low + high + 1) / 2;

            if (canRun(mid, batteries, n)) {
                low = mid;   // mid is possible, try bigger
            } else {
                high = mid - 1; // mid not possible
            }
        }

        return low;
    }

    private boolean canRun(long time, int[] batteries, int n) {
        long sum = 0;
        for (int b : batteries) {
            sum += Math.min(b, time);
        }
        return sum >= time * n;
    }
}
