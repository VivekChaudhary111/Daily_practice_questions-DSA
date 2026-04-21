// Last updated: 4/22/2026, 2:18:48 AM
1class Solution {
2    private int[] parent;
3
4    private int find(int x) {
5        if (parent[x] != x) parent[x] = find(parent[x]);
6        return parent[x];
7    }
8
9    private void unite(int a, int b) {
10        parent[find(a)] = find(b);
11    }
12
13    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
14        int n = source.length;
15        parent = new int[n];
16        for (int i = 0; i < n; i++) parent[i] = i;
17
18        for (int[] swap : allowedSwaps) {
19            unite(swap[0], swap[1]);
20        }
21
22        // Group source values by their component root
23        Map<Integer, Map<Integer, Integer>> groups = new HashMap<>();
24        for (int i = 0; i < n; i++) {
25            int root = find(i);
26            groups.computeIfAbsent(root, k -> new HashMap<>())
27                  .merge(source[i], 1, Integer::sum);
28        }
29
30        int hammingDist = 0;
31        for (int i = 0; i < n; i++) {
32            int root = find(i);
33            Map<Integer, Integer> freq = groups.get(root);
34            if (freq.getOrDefault(target[i], 0) > 0) {
35                freq.merge(target[i], -1, Integer::sum); // matched, consume this source value
36            } else {
37                hammingDist++;                           // no match found in this component
38            }
39        }
40
41        return hammingDist;
42    }
43}