class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int cnt = 0;
        boolean[] visited = new boolean[n];
        for(int i =0; i< n; i++){
            if(!visited[i]){
                cnt++;
                dfs(isConnected , visited , i);
            }
        }
        return cnt;
    }

    void dfs(int[][] adj, boolean[] visited, int node){
        visited[node] = true;
        for(int j =0; j< adj.length; j++){
            if(!visited[j] && adj[node][j] == 1){
                dfs(adj, visited , j);
            }
        }
    }
}