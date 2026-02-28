// Last updated: 3/1/2026, 1:30:59 AM
1class Solution {
2    public int concatenatedBinary(int n) {
3        int mod = 1_000_000_007;
4
5        long ans=0;
6        for(int i=1;i<=n;i++){
7            ans = ((ans<<len(i))%mod+i)%mod;
8        }
9
10        return (int)ans;
11    }
12
13    public int len(int n){
14        int l=0;
15        while(n>0){
16            l++;
17            n=(n>>1);
18        }
19        return l;
20    }
21}