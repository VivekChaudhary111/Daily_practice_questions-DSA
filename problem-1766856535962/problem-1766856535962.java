// Last updated: 12/27/2025, 10:58:55 PM
1class Solution {
2    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
3        int n = arrivals.length;
4        if (n == 0) return 0;
5
6        Map<Integer, Integer> map = new HashMap<>();
7        int[] kept = new int[n];
8        int dis = 0;
9
10        for (int i = 0; i < n; i++) {
11            int idx = i - w;
12            if (idx >= 0 && kept[idx] == 1) {
13                map.put(arrivals[idx], map.get(arrivals[idx]) - 1);
14            }
15
16            int t = arrivals[i];
17            if (map.getOrDefault(t, 0) < m) {
18                kept[i] = 1;
19                map.put(t, map.getOrDefault(t, 0) + 1);
20            } else {
21                dis++;
22            }
23        }
24        return dis;
25    }
26}