// Last updated: 3/7/2026, 10:46:34 PM
1class Solution {
2    public int minFlips(String s) {
3        int n = s.length();
4        s = s + s;
5
6        int case1 = 0, case2 = 0;
7        int left = 0;
8        int res = Integer.MAX_VALUE;
9
10        for (int right = 0; right < s.length(); right++) {
11
12            char c = s.charAt(right);
13            if (c != (right % 2 == 0 ? '0' : '1')) case1++;
14            if (c != (right % 2 == 0 ? '1' : '0')) case2++;
15
16            if (right - left + 1 > n) {
17                char lc = s.charAt(left);
18
19                if (lc != (left % 2 == 0 ? '0' : '1')) case1--;
20                if (lc != (left % 2 == 0 ? '1' : '0')) case2--;
21
22                left++;
23            }
24
25            if (right - left + 1 == n) {
26                res = Math.min(res, Math.min(case1, case2));
27            }
28        }
29
30        return res;
31    }
32}