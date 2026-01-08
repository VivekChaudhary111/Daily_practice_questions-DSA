// Last updated: 1/9/2026, 12:19:38 AM
1class Solution {
2    public int countHousePlacements(int n) {
3        long fibb = getFibo(n+2);
4        return (int) (fibb*fibb % 1000000007);
5    }
6    private long getFibo(int n){
7        if(n <= 1){
8            return n;
9        }
10        long a = 0, b = 1;
11        for(int i = 2; i <= n; i++){
12            long c = (a + b) % 1000000007;
13            a = b;
14            b = c;
15        }
16        return b;
17    }
18}