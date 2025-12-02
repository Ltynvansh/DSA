import java.util.*;

class Solution {
    private static final long MOD = 1_000_000_007L;

    public int countTrapezoids(int[][] points) {
        // Count points per y
        HashMap<Integer, Long> freq = new HashMap<>();
        for (int[] p : points) {
            int y = p[1];
            freq.put(y, freq.getOrDefault(y, 0L) + 1L);
        }

        // Compute a_y = C(count_y, 2)
        List<Long> a = new ArrayList<>();
        for (long cnt : freq.values()) {
            if (cnt >= 2) {
                long val = (cnt * (cnt - 1) / 2) % MOD; // C(cnt,2)
                a.add(val);
            }
        }

        if (a.size() < 2) return 0;

        long S = 0L;
        long sumSq = 0L;

        for (long v : a) {
            S = (S + v) % MOD;
            sumSq = (sumSq + (v * v) % MOD) % MOD;
        }

        long totalPairs = ((S * S) % MOD - sumSq + MOD) % MOD;

        long inv2 = (MOD + 1) / 2;  // modular inverse of 2 under mod
        long ans = (totalPairs * inv2) % MOD;

        return (int) ans;
    }
}
