class Solution {
     HashMap<Integer, List<Integer>> adj;
    boolean[] visited;
    int count = 0;
    int k;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.k = k;
        adj = new HashMap<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) adj.put(i, new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Use long for sums to avoid overflow
        dfs(0, values);
        return count;
    }

    // returns subtree sum (not modded) — parent uses it
    private long dfs(int node, int[] values) {
        if (visited[node]) return 0L;
        visited[node] = true;

        long sum = values[node];
        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                sum += dfs(nei, values);
            }
        }

        if (sum % k == 0) {
            count++;
            return 0L; // cut here: contribute 0 to parent
        }
        return sum; // pass full sum up (not modulo)
    }
}