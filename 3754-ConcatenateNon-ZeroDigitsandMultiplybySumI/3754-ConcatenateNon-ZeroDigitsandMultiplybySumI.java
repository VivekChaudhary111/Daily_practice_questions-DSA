// Last updated: 12/2/2025, 1:53:15 AM
1class Solution {
2    public long sumAndMultiply(int n) {
3        int sum = 0;
4        int nn = 0;
5        int factor = 0;
6        while(n > 0){
7            int rem = n % 10;
8            if(rem != 0){
9                sum += rem;
10                nn += rem * Math.pow(10, factor++);
11            }
12            n /= 10;
13        }
14        return (long) nn*sum;
15    }
16}