class Solution {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        boolean[] visited = new boolean[n];
        int[] minCost = new int[n];

        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[0] = 0;

        int ans = 0;

        for(int i = 0; i < n; i++) {

            int u = -1;

            for(int j = 0; j < n; j++) {
                if(!visited[j] &&
                  (u == -1 || minCost[j] < minCost[u])) {
                    u = j;
                }
            }

            visited[u] = true;
            ans += minCost[u];

            for(int v = 0; v < n; v++) {

                if(!visited[v]) {

                    int dist =
                        Math.abs(points[u][0] - points[v][0]) +
                        Math.abs(points[u][1] - points[v][1]);

                    minCost[v] =
                        Math.min(minCost[v], dist);
                }
            }
        }

        return ans;
    }
}