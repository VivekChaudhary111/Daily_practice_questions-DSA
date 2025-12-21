// Last updated: 12/21/2025, 8:03:41 AM
1class Solution {
2    public int mirrorDistance(int n) {
3        int newnum = 0;
4        int dup = n;
5        while(n > 0){
6            int rem = n%10;
7            newnum = newnum*10 + rem;
8            n/=10;
9        }
10        return Math.abs(dup - newnum);
11    }
12}