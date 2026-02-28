// Last updated: 3/1/2026, 1:32:31 AM
1class Solution {
2    public int concatenatedBinary(int n) {
3        int mod = 1_000_000_007;
4        int len = 0;
5        long ans=0;
6        for(int i=1;i<=n;i++){
7            if((i & (i-1)) == 0) len++;
8            ans = ((ans<<len)%mod+i)%mod;
9        }
10        return (int)ans;
11    }
12}