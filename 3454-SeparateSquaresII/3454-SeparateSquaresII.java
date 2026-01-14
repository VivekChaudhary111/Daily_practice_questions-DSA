// Last updated: 1/15/2026, 1:00:46 AM
1class Solution {
2    static class Event {
3        long y;
4        int x1, x2;
5        int type;
6
7        Event(long y, int x1, int x2, int type) {
8            this.y = y;
9            this.x1 = x1;
10            this.x2 = x2;
11            this.type = type;
12        }
13    }
14
15    static class SegmentTree {
16        int[] cnt;
17        double[] len;
18        double[] xs;
19
20        SegmentTree(double[] xs) {
21            this.xs = xs;
22            int n = xs.length - 1;
23            cnt = new int[4 * n];
24            len = new double[4 * n];
25        }
26
27        void update(int node, int start, int end, int add_start, int add_end, int val) {
28            if (add_start > end || add_end < start) return;
29
30            if (add_start <= start && end <= add_end) {
31                cnt[node] += val;
32                if (cnt[node] > 0) {
33                    len[node] = xs[end + 1] - xs[start];
34                } else {
35                    len[node] = (start == end) ? 0 : len[node * 2] + len[node * 2 + 1];
36                }
37                return;
38            }
39
40            int mid = (start + end) / 2;
41            update(node * 2, start, mid, add_start, add_end, val);
42            update(node * 2 + 1, mid + 1, end, add_start, add_end, val);
43
44            if (cnt[node] == 0) {
45                len[node] = len[node * 2] + len[node * 2 + 1];
46            }
47        }
48
49        double query() {
50            return len[1];
51        }
52    }
53
54    public double separateSquares(int[][] squares) {
55        Set<Integer> x_set = new TreeSet<>();
56        List<Event> events = new ArrayList<>();
57
58        for (int[] sq : squares) {
59            int xi = sq[0], yi = sq[1], li = sq[2];
60            int xj = xi + li, yj = yi + li;
61
62            x_set.add(xi);
63            x_set.add(xj);
64            events.add(new Event(yi, xi, xj, 1));
65            events.add(new Event(yj, xi, xj, -1));
66        }
67
68        List<Integer> x_list = new ArrayList<>(x_set);
69        int m = x_list.size();
70        double[] xs = new double[m];
71        for (int i = 0; i < m; i++) {
72            xs[i] = x_list.get(i);
73        }
74
75        Map<Integer, Integer> tree_to_list = new HashMap<>();
76        for (int i = 0; i < m; i++) {
77            tree_to_list.put(x_list.get(i), i);
78        }
79
80        events.sort((a, b) -> {
81            if (a.y != b.y) return Long.compare(a.y, b.y);
82            return Integer.compare(b.type, a.type);
83        });
84
85        double total_area = 0;
86        double prev_y = events.get(0).y;
87        SegmentTree seg1 = new SegmentTree(xs);
88
89        for (Event e : events) {
90            double y = e.y;
91            double height = y - prev_y;
92            double width = seg1.query();
93            total_area += width * height;
94
95            int start_idx = tree_to_list.get(e.x1);
96            int end_idx = tree_to_list.get(e.x2);
97            seg1.update(1, 0, m - 2, start_idx, end_idx - 1, e.type);
98
99            prev_y = y;
100        }
101
102        double target = total_area / 2.0;
103
104        prev_y = events.get(0).y;
105        double accumulated = 0;
106        SegmentTree seg2 = new SegmentTree(xs);
107
108        Event firstEvent = events.get(0);
109        seg2.update(1, 0, m - 2,
110                   tree_to_list.get(firstEvent.x1),
111                   tree_to_list.get(firstEvent.x2) - 1,
112                   firstEvent.type);
113
114        for (int i = 1; i < events.size(); i++) {
115            Event e = events.get(i);
116            double y = e.y;
117            double height = y - prev_y;
118            double width = seg2.query();
119
120            if (accumulated + width * height >= target) {
121                double need = target - accumulated;
122                return prev_y + need / width;
123            }
124
125            accumulated += width * height;
126            prev_y = y;
127
128            int start_idx = tree_to_list.get(e.x1);
129            int end_idx = tree_to_list.get(e.x2);
130            seg2.update(1, 0, m - 2, start_idx, end_idx - 1, e.type);
131        }
132
133        return prev_y;
134    }
135}