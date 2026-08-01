class Solution {
    List<Integer>[] graph;
    int[] count;
    int[] ans;
    int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        count = new int[n];
        ans = new int[n];

        dfs1(0, -1);
        dfs2(0, -1);

        return ans;
    }

    private void dfs1(int node, int parent) {
        count[node] = 1;

        for (int child : graph[node]) {
            if (child == parent) continue;

            dfs1(child, node);
            count[node] += count[child];
            ans[node] += ans[child] + count[child];
        }
    }

    private void dfs2(int node, int parent) {
        for (int child : graph[node]) {
            if (child == parent) continue;

            ans[child] = ans[node] - count[child] + (n - count[child]);
            dfs2(child, node);
        }
    }
}