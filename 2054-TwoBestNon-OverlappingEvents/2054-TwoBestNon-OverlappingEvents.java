// Last updated: 12/24/2025, 1:45:58 AM
1class Solution {
2    public int maxTwoEvents(int[][] events) {
3        Arrays.sort(events, (a, b) -> a[0] - b[0]);
4
5        int n = events.length;
6        int[] suffixMax = new int[n + 1];
7
8        for (int i = n - 1; i >= 0; i--) {
9            suffixMax[i] = Math.max(suffixMax[i + 1], events[i][2]);
10        }
11
12        int ans = 0;
13
14        for (int i = 0; i < n; i++) {
15            int next = nextIndex(events, events[i][1]);
16            ans = Math.max(ans, events[i][2] + suffixMax[next]);
17        }
18
19        return ans;
20    }
21
22    public int nextIndex(int[][] events, int endTime) {
23        int lo = 0, hi = events.length - 1;
24        int ans = events.length;
25
26        while (lo <= hi) {
27            int mid = lo + (hi - lo) / 2;
28            if (events[mid][0] > endTime) {
29                ans = mid;
30                hi = mid - 1;
31            } else {
32                lo = mid + 1;
33            }
34        }
35        return ans;
36    }
37}
38