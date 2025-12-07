// Last updated: 12/7/2025, 8:40:14 AM
1class Solution {
2    int[] good;
3    List<List<Integer>> adj;
4    int[] dp;
5    int[] ans;
6
7    public int[] maxSubgraphScore(int n, int[][] edges, int[] good) {
8        this.good = good;
9        this.adj = new ArrayList<>();
10        this.dp = new int[n];
11        this.ans = new int[n];
12
13        for (int i = 0; i < n; i++) {
14            adj.add(new ArrayList<>());
15        }
16        for (int[] e : edges) {
17            adj.get(e[0]).add(e[1]);
18            adj.get(e[1]).add(e[0]);
19        }
20
21        dfs(0, -1);
22        dfs(0, -1, 0);
23
24        return ans;
25    }
26    public void dfs(int u, int p) {
27        dp[u] = (good[u] == 1) ? 1 : -1;
28
29        for (int v : adj.get(u)) {
30            if (v == p) continue;
31            
32            dfs(v, u);
33            
34            if (dp[v] > 0) {
35                dp[u] += dp[v];
36            }
37        }
38    }
39    public void dfs(int u, int p, int pNode) {
40        ans[u] = dp[u] + pNode;
41
42        for (int v : adj.get(u)) {
43            if (v == p) continue;
44            int valU = ans[u] - (dp[v] > 0 ? dp[v] : 0);
45            int nextpNode = (valU > 0) ? valU : 0;
46            
47            dfs(v, u, nextpNode);
48        }
49    }
50}