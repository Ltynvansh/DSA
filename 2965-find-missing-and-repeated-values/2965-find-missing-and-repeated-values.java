class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        HashSet<Integer> set = new HashSet<>();

        int a = 0, b = 0;
        long actualSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                actualSum += val;

                if (set.contains(val)) {
                    a = val; // repeating number
                }
                set.add(val);
            }
        }

        long N = (long) n * n; 
        long expectedSum = N * (N + 1) / 2;

        b = (int)(expectedSum + a - actualSum);

        return new int[]{a, b};
    }
}
