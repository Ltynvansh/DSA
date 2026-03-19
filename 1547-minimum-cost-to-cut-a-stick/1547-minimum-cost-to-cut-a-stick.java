import java.util.*;

class Solution {
    HashMap<List<Integer>, Integer> map = new HashMap<>();

    public int minCost(int n, int[] cuts) {
        return cost(cuts, 0, n);
    }

    public int cost(int[] cuts, int l, int r) {
        List<Integer> key = Arrays.asList(l, r);

        if (map.containsKey(key)) return map.get(key);

        int min = Integer.MAX_VALUE;

        for (int i : cuts) {
            if (i <= l || i >= r) continue;

            int temp = cost(cuts, l, i) + cost(cuts, i, r);
            min = Math.min(min, temp + (r - l));
        }

        if (min == Integer.MAX_VALUE) min = 0;

        map.put(key, min);
        return min;
    }
}