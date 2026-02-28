// Last updated: 3/1/2026, 1:25:17 AM
1class Solution {
2    public int concatenatedBinary(int n) {
3        long mul = 1;
4        long curr = 0;
5        int MOD = 1_000_000_007;
6        while(n > 0){
7            String bin = Integer.toBinaryString(n);
8            for(int i = bin.length()-1; i >= 0; i--){
9                if(bin.charAt(i) == '1'){
10                    curr = (curr + mul)%MOD;
11                }
12                mul = (mul * 2) % MOD;
13            }
14            n--;
15        }
16        return (int)curr;
17    }
18}