import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        // Step 1: Sort
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) 
                return b[1] - a[1]; // height desc if width same
            return a[0] - b[0];     // width asc
        });

        // Step 2: LIS on heights
        ArrayList<Integer> lis = new ArrayList<>();

        for (int[] env : envelopes) {
            int h = env[1];

            int idx = Collections.binarySearch(lis, h);

            if (idx < 0) {
                idx = -(idx + 1); // insertion point
            }

            if (idx == lis.size()) {
                lis.add(h);
            } else {
                lis.set(idx, h);
            }
        }

        return lis.size();
    }
}