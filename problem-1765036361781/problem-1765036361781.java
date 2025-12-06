// Last updated: 12/6/2025, 9:22:41 PM
1class Solution {
2    public long maxPoints(int[] technique1, int[] technique2, int k) {
3        long ans = 0;
4        int n = technique1.length;
5        int[] arrD = new int[n];
6        
7        for (int i = 0; i < n; i++) {
8            ans += technique2[i];
9            arrD[i] = technique1[i] - technique2[i];
10        }
11        
12        Arrays.sort(arrD);
13        
14        for (int i = n - 1; i >= 0; i--) {
15            if (i >= n - k) {
16                ans += arrD[i];
17            } else {
18                if (arrD[i] > 0) {
19                    ans += arrD[i];
20                } else {
21                    break;
22                }
23            }
24        }
25        
26        return ans;
27    }
28}