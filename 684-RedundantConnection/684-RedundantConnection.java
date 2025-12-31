// Last updated: 12/31/2025, 3:16:54 PM
1class Solution {
2    public int[] findRedundantConnection(int[][] edges) {
3        int n = edges.length;
4        DSU dsu = new DSU(n + 1); // +1 for 1-based nodes
5
6        for (int[] e : edges) {
7            int u = e[0];
8            int v = e[1];
9
10            if (dsu.find(u) == dsu.find(v)) {
11                return e; // cycle found
12            }
13            dsu.union(u, v);
14        }
15        return new int[0];
16    }
17
18    class DSU {
19        int[] parent, size;
20
21        DSU(int n) {
22            parent = new int[n];
23            size = new int[n];
24            for (int i = 0; i < n; i++) {
25                parent[i] = i;
26                size[i] = 1;
27            }
28        }
29
30        int find(int x) {
31            if (parent[x] != x)
32                parent[x] = find(parent[x]);
33            return parent[x];
34        }
35
36        void union(int a, int b) {
37            int pa = find(a);
38            int pb = find(b);
39            if (pa == pb) return;
40
41            if (size[pa] < size[pb]) {
42                parent[pa] = pb;
43                size[pb] += size[pa];
44            } else {
45                parent[pb] = pa;
46                size[pa] += size[pb];
47            }
48        }
49    }
50}
51