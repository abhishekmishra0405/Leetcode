
import java.util.*;

class Solution {
    int[] ans;
    List<Integer>[] adj;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] tree = new ArrayList[n];
        adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] newParent = parent.clone();
        int[] last = new int[26];
        Arrays.fill(last, -1);

        dfs(0, tree, s, last, newParent);

        for (int i = 1; i < n; i++) {
            adj[newParent[i]].add(i);
        }

        ans = new int[n];
        calculate(0);

        return ans;
    }

    void dfs(int node, List<Integer>[] tree, String s,
             int[] last, int[] newParent) {

        int c = s.charAt(node) - 'a';
        int old = last[c];

        if (old != -1) {
            newParent[node] = old;
        }

        last[c] = node;

        for (int child : tree[node]) {
            dfs(child, tree, s, last, newParent);
        }

        last[c] = old;
    }

    int calculate(int node) {
        int size = 1;

        for (int child : adj[node]) {
            size += calculate(child);
        }

        ans[node] = size;
        return size;
    }
}
