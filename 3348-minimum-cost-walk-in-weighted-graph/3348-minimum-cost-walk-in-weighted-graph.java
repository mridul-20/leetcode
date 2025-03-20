class Solution {
    int[] parent, rank, minAND; 

    // Find function (with path compression)
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union function (with rank-based merging)
    private void union(int u, int v, int weight) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
                minAND[rootU] &= minAND[rootV];
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
                minAND[rootV] &= minAND[rootU];
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
                minAND[rootU] &= minAND[rootV];
            }
        }
        minAND[find(u)] &= weight; // Update minAND for the component
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        parent = new int[n];
        rank = new int[n];
        minAND = new int[n];

        // Initialize DSU
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            minAND[i] = Integer.MAX_VALUE;
        }

        // Union all edges
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            union(u, v, w);
        }

        // Answer queries
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int si = query[i][0], ti = query[i][1];
            if (find(si) != find(ti)) {
                answer[i] = -1; // Different components
            } else {
                answer[i] = minAND[find(si)]; // Minimum AND value in the component
            }
        }

        return answer;
    }
}
