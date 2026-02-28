// Last updated: 3/1/2026, 1:29:56 AM
1class Solution {
2    public int concatenatedBinary(int n) {
3        long res = 0;
4        int MOD = 1_000_000_007;
5        int len = 0;
6
7        for (int i = 1; i <= n; i++) {
8            if ((i & (i - 1)) == 0) {
9                len++;
10            }
11            res = ((res << len) % MOD + i) % MOD;
12        }
13
14        return (int) res;
15    }
16}